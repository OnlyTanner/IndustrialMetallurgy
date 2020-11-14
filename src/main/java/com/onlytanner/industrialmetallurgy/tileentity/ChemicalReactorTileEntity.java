package com.onlytanner.industrialmetallurgy.tileentity;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.blocks.ChemicalReactorBlock;
import com.onlytanner.industrialmetallurgy.containers.ChemicalReactorContainer;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import com.onlytanner.industrialmetallurgy.items.BurrSetBase;
import com.onlytanner.industrialmetallurgy.recipes.ChemicalReactorRecipe;
import com.onlytanner.industrialmetallurgy.recipes.RecipeSerializerInit;
import com.onlytanner.industrialmetallurgy.util.ModItemHandler;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
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
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChemicalReactorTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider, IEnergyStorage {

    public static final int INPUT_ID = 0;
    public static final int BOTTLE_ID = 3;
    public static final int OUTPUT_ID = 4;
    private ITextComponent customName;
    public int currentSmeltTime;
    public final int MAX_SMELT_TIME = 50;
    private ModItemHandler inventory;
    public int energy;
    public final int MAX_ENERGY = 100000;
    public final int ENERGY_USAGE_PER_TICK = 40;

    public ChemicalReactorTileEntity() {
        this(ModTileEntityTypes.CHEMICAL_REACTOR.get());
    }

    private ChemicalReactorTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        customName = new TranslationTextComponent("Chemical Reactor");
        inventory = new ModItemHandler(5);
        energy = 0;
    }

    @Override
    public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
        return new ChemicalReactorContainer(windowID, playerInv, this);
    }

    @Override
    public void tick() {
        boolean dirty = false;
        if (this.world != null && !this.world.isRemote) {
            if (canProcess() && energy > ENERGY_USAGE_PER_TICK && currentSmeltTime < MAX_SMELT_TIME) {
                energy -= ENERGY_USAGE_PER_TICK;
                currentSmeltTime ++;
            }
            else if (canProcess() && currentSmeltTime == MAX_SMELT_TIME) {
                processRecipe();
                currentSmeltTime = 0;
                dirty = true;
            }
            else {
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
        List<ItemStack> output = this.getRecipe().getAllOutput();
        this.inventory.insertItem(OUTPUT_ID, output.get(0).copy(), false);
        this.inventory.insertItem(BOTTLE_ID, output.get(1).copy(), false);
        if (this.inventory.getStackInSlot(INPUT_ID) != ItemStack.EMPTY) {
            ItemStack[] list = this.getRecipe().getInput().getMatchingStacks();
            for (int j = 0; j < list.length; j++) {
                if (list[j].getItem().equals(this.getInventory().getStackInSlot(INPUT_ID).getItem())) {
                    this.inventory.decrStackSize(INPUT_ID, list[j].getCount());
                }
            }
        }
    }

    public boolean canProcess() {
        if (getRecipe() != null && getRecipe().matches(new RecipeWrapper(this.inventory), world) &&
            (this.inventory.getStackInSlot(OUTPUT_ID).getCount() < 64) &&
            ((this.inventory.getStackInSlot(OUTPUT_ID) == ItemStack.EMPTY) ||
            (this.inventory.getStackInSlot(OUTPUT_ID).getItem().equals(getRecipe().getAllOutput().get(0).getItem()))) &&
            (this.inventory.getStackInSlot(BOTTLE_ID).getCount() < 64) &&
            ((this.inventory.getStackInSlot(BOTTLE_ID) == ItemStack.EMPTY) ||
            (this.inventory.getStackInSlot(BOTTLE_ID).getItem().equals(getRecipe().getAllOutput().get(1).getItem()))))
            return true;
        return false;
    }

    public void setCustomName(ITextComponent name) {
        this.customName = name;
    }

    public ITextComponent getName() {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    public ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + IndustrialMetallurgy.MOD_ID + ".chemical_reactor");
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
        this.energy = nbt.getInt("Energy");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (this.customName != null) {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
        }
        ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
        compound.putInt("CurrentSmeltTime", this.currentSmeltTime);
        compound.putInt("Energy", this.energy);
        return compound;
    }

    @Nullable
    private ChemicalReactorRecipe getRecipe() {
        if (this.inventory == null)
            return null;
        Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.CHEMICAL_REACTOR_RECIPE_TYPE, this.world);
        for (IRecipe<?> iRecipe : recipes) {
            ChemicalReactorRecipe recipe = (ChemicalReactorRecipe) iRecipe;
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
        if (cap.getName().equals(CapabilityEnergy.ENERGY.getName())) {
            return CapabilityEnergy.ENERGY.orEmpty(cap, LazyOptional.of(() -> this));
        }
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int result = (this.energy <= MAX_ENERGY - maxReceive) ? maxReceive : MAX_ENERGY - this.energy;
        if (!simulate && result > 0)
            this.energy += result;
        return result;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return this.energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return this.MAX_ENERGY;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return (energy < MAX_ENERGY);
    }
}
