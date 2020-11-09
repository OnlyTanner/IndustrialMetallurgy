package com.onlytanner.industrialmetallurgy.tileentity;

import com.onlytanner.industrialmetallurgy.blocks.ForgeTier1Block;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier1Container;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.RecipeSerializerInit;
import com.onlytanner.industrialmetallurgy.util.ForgeItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class ForgeTier1TileEntity extends ModTileEntityBase implements ITickableTileEntity, ISidedInventory {

    private ForgeTier1Container container;
    public static final int INVENTORY_SIZE = 9 + 27 + 8;
    public static final int NUM_INPUT_SLOTS = 6;
    public int x, y, z, tick;
    private NonNullList<ItemStack> invContents = NonNullList.withSize(INVENTORY_SIZE, ItemStack.EMPTY);
    protected int numPlayerUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
    private ITextComponent customName;
    private ForgeItemHandler inventory;
    public final ItemStack[] teContents;
    public int currentSmeltTime;
    public final int maxSmeltTime = 100;

    public ForgeTier1TileEntity() {
        this(ModTileEntityTypes.FORGE_TIER1.get());
    }

    private ForgeTier1TileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        customName = new TranslationTextComponent("Iron Forge (Tier 1)");
        teContents = new ItemStack[8];
        for (int i = 0; i < teContents.length; i++)
            teContents[i] = ItemStack.EMPTY;
        inventory = new ForgeItemHandler(8, teContents);
        container = null;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.forge_tier1");
    }

    @Override
    public ITextComponent getDisplayName() {
        return customName;
    }

    @Nullable
    public ITextComponent getCustomName() {
        return customName;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        if (container == null)
            container = new ForgeTier1Container(id, player, this);
        return container;
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.invContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.invContents = itemsIn;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.invContents);
        }
        ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
        compound.putInt("CurrentSmeltTime", this.currentSmeltTime);
        compound.put("Fuel", teContents[ForgeTier1Container.FUEL_ID].serializeNBT());
        compound.put("Output", teContents[ForgeTier1Container.OUTPUT_ID].serializeNBT());
        for (int i = 0; i < 6; i++) {
            compound.put("Input" + i, teContents[i].serializeNBT());
        }
        return compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT compound)  {
        super.checkLootAndRead(compound);
        this.invContents = NonNullList.withSize(this.INVENTORY_SIZE, ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.invContents);
        }
        NonNullList<ItemStack> inv = NonNullList.<ItemStack>withSize(this.inventory.getSlots(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, inv);
        this.inventory.setNonNullList(inv);
        this.currentSmeltTime = compound.getInt("CurrentSmeltTime");
        teContents[ForgeTier1Container.FUEL_ID].deserializeNBT(compound.getCompound("Fuel"));
        teContents[ForgeTier1Container.OUTPUT_ID].deserializeNBT(compound.getCompound("Output"));
        for (int i = 0; i < 6; i++) {
            teContents[i].deserializeNBT(compound.getCompound("Input" + i));
        }
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayerUsing = type;
            return true;
        }
        else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayerUsing < 0) {
                this.numPlayerUsing = 0;
            }
            this.numPlayerUsing++;
            this.openOrClose();
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            this.numPlayerUsing--;
            this.openOrClose();
        }
    }

    protected void openOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof ForgeTier1Block) {
            this.world.addBlockEvent(this.pos, block, 1, this.numPlayerUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }

    public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
        BlockState state = reader.getBlockState(pos);
        if (state.hasTileEntity()) {
            TileEntity te = reader.getTileEntity(pos);
            if (te instanceof ForgeTier1TileEntity) {
                return ((ForgeTier1TileEntity) te).numPlayerUsing;
            }
        }
        return 0;
    }

    public static void swapContents(ForgeTier1TileEntity te, ForgeTier1TileEntity otherTe) {
        NonNullList<ItemStack> list = te.getItems();
        te.setItems(otherTe.getItems());
        otherTe.setItems(list);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
    }

    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }

    @Override
    public void remove() {
        super.remove();
        if (itemHandler != null) {
            itemHandler.invalidate();
            itemHandler = null;
        }
    }

    @Override
    public void tick() {
        boolean dirty = false;
        if (this.world != null && !this.world.isRemote) {
            if (this.getRecipe(Arrays.copyOfRange(teContents, 0, 6)) != null) {
                if (this.currentSmeltTime != this.maxSmeltTime) {
                    this.world.setBlockState(this.getPos(),
                            this.getBlockState().with(ForgeTier1Block.LIT, true));
                    this.currentSmeltTime++;
                    dirty = true;
                } else {
                    this.world.setBlockState(this.getPos(),
                            this.getBlockState().with(ForgeTier1Block.LIT, false));
                    this.currentSmeltTime = 0;
                    ItemStack output = this.getRecipe(Arrays.copyOfRange(teContents, 0, 6)).getRecipeOutput();
                    this.inventory.insertItem(1, output.copy(), false);
                    this.inventory.decrStackSize(0, 1);
                    dirty = true;
                }
            }
        }
        if (dirty) {
            this.markDirty();
            this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        }
        tick++;
    }

    @Nullable
    private ForgeRecipe getRecipe(ItemStack[] items) {
        if (items == null)
            return null;
        Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.FORGE_RECIPE_TYPE, this.world);
        for (IRecipe<?> i : recipes) {
            ForgeRecipe recipe = (ForgeRecipe) i;
            if (recipe.matches(new RecipeWrapper(this.inventory), this.world))
                return recipe;
        }
        return null;
    }

    public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> type, World world) {
        return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == type).collect(Collectors.toSet()) : Collections.emptySet();
    }

    @OnlyIn(Dist.CLIENT)
    public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> type) {
        ClientWorld world = Minecraft.getInstance().world;
        return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == type).collect(Collectors.toSet()) : Collections.emptySet();
    }

    public static Set<ItemStack> getAllRecipeInput(IRecipeType<?> type, World world) {
        Set<ItemStack> inputs = new HashSet<>();
        Set<IRecipe<?>> recipes = findRecipesByType(type, world);
        for (IRecipe<?> recipe : recipes) {
            NonNullList<Ingredient> ingredients = recipe.getIngredients();
            ingredients.forEach(ingredient -> {
                for (ItemStack stack : ingredient.getMatchingStacks()) {
                    inputs.add(stack);
                }
            });
        }
        return inputs;
    }

    public void dropAllContents(World worldIn, BlockPos pos) {
        InventoryHelper.dropInventoryItems(worldIn, pos, this);
    }

    @Override
    public int getSizeInventory() {
        return INVENTORY_SIZE;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return false;
    }

    public final IItemHandlerModifiable getInventory() {
        return this.inventory;
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);
        return new SUpdateTileEntityPacket(this.pos, 0, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(this.getBlockState(), pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);
        return nbt;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
    }

}
