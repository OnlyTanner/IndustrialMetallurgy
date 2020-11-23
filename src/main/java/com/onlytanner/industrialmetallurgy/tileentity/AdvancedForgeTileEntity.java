package com.onlytanner.industrialmetallurgy.tileentity;

import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.util.ModItemHandler;
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

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AdvancedForgeTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider, IEnergyStorage {

    public static final int NUM_INPUT_SLOTS = 4;
    public static final int OUTPUT_ID = 5;
    protected ITextComponent customName;
    public int currentSmeltTime;
    public int currentTemperature;
    public int energy;
    public final int MAX_ENERGY = 100000;
    public final int ENERGY_USAGE_PER_TICK = 40;
    protected ModItemHandler inventory;
    public int maxSmeltTime;
    public int maxTemperature;
    public int degreesPerTick;

    protected AdvancedForgeTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        inventory = new ModItemHandler(5);
        currentTemperature = 0;
        this.maxSmeltTime = 100;
        this.maxTemperature = 3000;
        this.degreesPerTick = 5;
    }

    @Override
    public abstract Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn);

    @Override
    public abstract void tick();

    public void setCustomName(ITextComponent name) {
        this.customName = name;
    }

    public ITextComponent getName() {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    public abstract ITextComponent getDefaultName();

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
        this.energy = nbt.getInt("CurrentEnergy");
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
        compound.putInt("CurrentEnergy", this.energy);
        return compound;
    }

    @Nullable
    protected abstract ForgeRecipe getRecipe();

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
