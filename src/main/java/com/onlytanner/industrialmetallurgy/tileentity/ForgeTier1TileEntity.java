package com.onlytanner.industrialmetallurgy.tileentity;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.blocks.ForgeTier1Block;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier1Container;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.RecipeSerializerInit;
import com.onlytanner.industrialmetallurgy.util.ForgeItemHandler;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ForgeTier1TileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    public static final int NUM_INPUT_SLOTS = 4;
    public static final int OUTPUT_ID = 5;
    public static final int FUEL_ID = 4;
    private ITextComponent customName;
    public int currentSmeltTime;
    public int burnTimeRemaining;
    public int currentTemperature;
    public final int MAX_BURN_TIME = 1600;
    public final int MAX_SMELT_TIME = 50;
    public final int MAX_TEMPERATURE = 2000;
    private ForgeItemHandler inventory;

    public ForgeTier1TileEntity() {
        this(ModTileEntityTypes.FORGE_TIER1.get());
    }

    private ForgeTier1TileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        customName = new TranslationTextComponent("Iron Forge (Tier 1)");
        inventory = new ForgeItemHandler(6);
        burnTimeRemaining = 0;
        currentTemperature = 0;
    }

    @Override
    public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
        return new ForgeTier1Container(windowID, playerInv, this);
    }

    @Override
    public void tick() {
        boolean dirty = false;
        if (this.world != null && !this.world.isRemote) {
            if (this.getRecipe() != null && canProcess() && burnTimeRemaining > 0 && currentTemperature > 1500) {
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier1Block.LIT, true));
                if (this.currentSmeltTime != this.MAX_SMELT_TIME) {
                    this.currentSmeltTime++;
                    this.currentTemperature = (this.currentTemperature < MAX_TEMPERATURE) ? this.currentTemperature + 5 : MAX_TEMPERATURE;
                    this.burnTimeRemaining--;
                    dirty = true;
                } else {
                    this.currentSmeltTime = 0;
                    this.currentTemperature = (this.currentTemperature < MAX_TEMPERATURE) ? this.currentTemperature + 5 : MAX_TEMPERATURE;
                    this.burnTimeRemaining--;
                    if (canProcess())
                        processRecipe();
                    dirty = true;
                }
            }
            else if (this.burnTimeRemaining == 0 && hasFuel() && canProcess()) {
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier1Block.LIT, true));
                this.currentTemperature = (this.currentTemperature < MAX_TEMPERATURE) ? this.currentTemperature + 5 : MAX_TEMPERATURE;
                consumeFuel();
                dirty = true;
            }
            else {
                if (burnTimeRemaining > 0) {
                    this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier1Block.LIT, true));
                    this.currentTemperature = (this.currentTemperature < MAX_TEMPERATURE) ? this.currentTemperature + 5 : MAX_TEMPERATURE;
                    this.burnTimeRemaining--;
                }
                else {
                    this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier1Block.LIT, false));
                    this.currentTemperature = (this.currentTemperature > 0) ? this.currentTemperature - 5 : 0;
                }
                currentSmeltTime = 0;
            }
        }
        if (dirty) {
            this.markDirty();
            this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(),
                    Constants.BlockFlags.BLOCK_UPDATE);
        }
    }

    public void processRecipe() {
        ItemStack output = this.getRecipe().getRecipeOutput();
        this.inventory.insertItem(OUTPUT_ID, output.copy(), false);
        for (int i = 0; i < NUM_INPUT_SLOTS; i++) {
            if (this.inventory.getStackInSlot(i) != ItemStack.EMPTY) {
                ItemStack[] list = this.getRecipe().getInput().getMatchingStacks();
                for (int j = 0; j < list.length; j++) {
                    if (list[j].getItem().equals(this.getInventory().getStackInSlot(i).getItem())) {
                        this.inventory.decrStackSize(i, list[j].getCount());
                    }
                }
            }
        }
    }

    public boolean canProcess() {
        if (getRecipe() != null && getRecipe().matches(new RecipeWrapper(this.inventory), world) &&
            (this.inventory.getStackInSlot(OUTPUT_ID).getCount() < 64) &&
            ((this.inventory.getStackInSlot(OUTPUT_ID) == ItemStack.EMPTY) ||
            (this.inventory.getStackInSlot(OUTPUT_ID).getItem().equals(getRecipe().getRecipeOutput().getItem()))))
            return true;
        return false;
    }

    public boolean hasFuel() {
        if (this.inventory.getStackInSlot(FUEL_ID) != ItemStack.EMPTY && this.inventory.getStackInSlot(FUEL_ID).getCount() > 0)
            return true;
        return false;
    }

    public void consumeFuel() {
        this.inventory.getStackInSlot(FUEL_ID).setCount(this.getInventory().getStackInSlot(FUEL_ID).getCount() - 1);
        burnTimeRemaining = MAX_BURN_TIME;
    }

    public void setCustomName(ITextComponent name) {
        this.customName = name;
    }

    public ITextComponent getName() {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    public ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + IndustrialMetallurgy.MOD_ID + ".forge_tier1");
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.getName();
    }

    @Nullable
    public ITextComponent getCustomName() {
        return this.customName;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        if (nbt.contains("CustomName", Constants.NBT.TAG_STRING)) {
            this.customName = ITextComponent.Serializer.getComponentFromJson(nbt.getString("CustomName"));
        }
        NonNullList<ItemStack> inv = NonNullList.<ItemStack>withSize(this.inventory.getSlots(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, inv);
        this.inventory.setNonNullList(inv);
        this.currentSmeltTime = nbt.getInt("CurrentSmeltTime");
        this.currentTemperature = nbt.getInt("CurrentTemperature");
        this.burnTimeRemaining = nbt.getInt("BurnTimeRemaining");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (this.customName != null) {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
        }
        ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
        compound.putInt("CurrentSmeltTime", this.currentSmeltTime);
        compound.putInt("CurrentTemperature", this.currentTemperature);
        compound.putInt("BurnTimeRemaining", this.burnTimeRemaining);
        return compound;
    }

    @Nullable
    private ForgeRecipe getRecipe() {
        if (this.inventory == null)
            return null;
        Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.FORGE_RECIPE_TYPE, this.world);
        for (IRecipe<?> iRecipe : recipes) {
            ForgeRecipe recipe = (ForgeRecipe) iRecipe;
            if (recipe.matches(new RecipeWrapper(this.inventory), this.world)) {
                return recipe;
            }
        }
        return null;
    }

    public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> typeIn, World world) {
        return world != null ? world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
    }

    @SuppressWarnings("resource")
    @OnlyIn(Dist.CLIENT)
    public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> typeIn) {
        ClientWorld world = Minecraft.getInstance().world;
        return world != null ? world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
    }

    public static Set<ItemStack> getAllRecipeInputs(IRecipeType<?> typeIn, World worldIn) {
        Set<ItemStack> inputs = new HashSet<ItemStack>();
        Set<IRecipe<?>> recipes = findRecipesByType(typeIn, worldIn);
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
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        this.read(state, tag);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
    }

}
