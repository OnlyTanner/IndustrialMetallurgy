package com.onlytanner.industrialmetallurgy.tileentity;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.blocks.ThermoelectricGeneratorBlock;
import com.onlytanner.industrialmetallurgy.containers.ThermoelectricGeneratorContainer;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import com.onlytanner.industrialmetallurgy.util.ModItemHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nullable;

public class ThermoelectricGeneratorTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider, IEnergyStorage {

    public static final int FUEL_ID = 0;
    public static final int NUM_EXTRA_FUEL_SLOTS = 4;
    private ITextComponent customName;
    public int burnTimeRemaining;
    public int currentMaxBurnTime;
    private ModItemHandler inventory;
    public int energy;
    public final int MAX_ENERGY = 500000;
    public final int MAX_ENERGY_PROVIDED = 80;
    public final int ENERGY_GENERATED_PER_TICK = 80;

    public ThermoelectricGeneratorTileEntity() {
        this(ModTileEntityTypes.THERMOELECTRIC_GENERATOR.get());
    }

    private ThermoelectricGeneratorTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        customName = new TranslationTextComponent("TE Generator");
        inventory = new ModItemHandler(5);
        energy = 0;
        currentMaxBurnTime = 0;
        burnTimeRemaining = 0;
    }

    @Override
    public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
        return new ThermoelectricGeneratorContainer(windowID, playerInv, this);
    }

    @Override
    public void tick() {
        boolean dirty = false;
        if (this.world != null && !this.world.isRemote) {
            for (int i = 0; i < NUM_EXTRA_FUEL_SLOTS; i++) {
                if (this.inventory.getStackInSlot(1 + i).getCount() > 0 && this.inventory.getStackInSlot(FUEL_ID).getCount() == 0) {
                    this.inventory.setStackInSlot(FUEL_ID, this.inventory.getStackInSlot(1 + i).copy());
                    this.inventory.getStackInSlot(1 + i).setCount(0);
                    i = NUM_EXTRA_FUEL_SLOTS;
                }
                else if (this.inventory.getStackInSlot(1 + i).getCount() > 0 && this.inventory.getStackInSlot(FUEL_ID).getCount() > 0 &&
                    this.inventory.getStackInSlot(FUEL_ID).getCount() < 64 && this.inventory.getStackInSlot(1 + i).getItem().equals(this.inventory.getStackInSlot(FUEL_ID).getItem())) {
                    this.inventory.getStackInSlot(FUEL_ID).setCount(this.inventory.getStackInSlot(FUEL_ID).getCount() + 1);
                    this.inventory.decrStackSize(1 + i, 1);
                    i = NUM_EXTRA_FUEL_SLOTS;
                }
            }
            //System.out.println("HAS FUEL: " + hasFuel() + ", burnTime: " + burnTimeRemaining + ", energy: " + energy);
            if (hasFuel() && burnTimeRemaining == 0 && this.energy < MAX_ENERGY) {
                consumeFuel();
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ThermoelectricGeneratorBlock.LIT, true));
                dirty = true;
            }
            else if (burnTimeRemaining > 0 && energy < (MAX_ENERGY - ENERGY_GENERATED_PER_TICK)) {
                this.burnTimeRemaining--;
                this.energy += ENERGY_GENERATED_PER_TICK;
            }
            else if (burnTimeRemaining > 0 && energy == MAX_ENERGY) {
                this.burnTimeRemaining--;
            }
            else {
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ThermoelectricGeneratorBlock.LIT, false));
                dirty = true;
            }
            if (this.canExtract())
                providePowerToNeighbors();
        }
        if (dirty) {
            this.markDirty();
            this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(),
                    Constants.BlockFlags.BLOCK_UPDATE);
        }
    }

    private void providePowerToNeighbors() {
        int numNeighbors = 0;
        IEnergyStorage[] neighbors = new IEnergyStorage[6];
        if (this.world.getTileEntity(this.pos.up()) instanceof IEnergyStorage && ((IEnergyStorage) this.world.getTileEntity(this.pos.up())).canReceive()) {
            neighbors[0] = (IEnergyStorage) this.world.getTileEntity(this.pos.up());
            numNeighbors++;
        }
        if (this.world.getTileEntity(this.pos.down()) instanceof IEnergyStorage && ((IEnergyStorage) this.world.getTileEntity(this.pos.down())).canReceive()) {
            neighbors[1] = (IEnergyStorage) this.world.getTileEntity(this.pos.down());
            numNeighbors++;
        }
        if (this.world.getTileEntity(this.pos.north()) instanceof IEnergyStorage && ((IEnergyStorage) this.world.getTileEntity(this.pos.north())).canReceive()) {
            neighbors[2] = (IEnergyStorage) this.world.getTileEntity(this.pos.north());
            numNeighbors++;
        }
        if (this.world.getTileEntity(this.pos.south()) instanceof IEnergyStorage && ((IEnergyStorage) this.world.getTileEntity(this.pos.south())).canReceive()) {
            neighbors[3] = (IEnergyStorage) this.world.getTileEntity(this.pos.south());
            numNeighbors++;
        }
        if (this.world.getTileEntity(this.pos.east()) instanceof IEnergyStorage && ((IEnergyStorage) this.world.getTileEntity(this.pos.east())).canReceive()) {
            neighbors[4] = (IEnergyStorage) this.world.getTileEntity(this.pos.east());
            numNeighbors++;
        }
        if (this.world.getTileEntity(this.pos.west()) instanceof IEnergyStorage && ((IEnergyStorage) this.world.getTileEntity(this.pos.west())).canReceive()) {
            neighbors[5] = (IEnergyStorage) this.world.getTileEntity(this.pos.west());
            numNeighbors++;
        }
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] != null) {
                int result = neighbors[i].receiveEnergy(this.extractEnergy(MAX_ENERGY_PROVIDED / numNeighbors, true), false);
                this.extractEnergy(result, false);
            }
        }
    }

    public boolean hasFuel() {
        if (this.inventory.getStackInSlot(FUEL_ID) != ItemStack.EMPTY && this.inventory.getStackInSlot(FUEL_ID).getCount() > 0)
            return true;
        return false;
    }

    public void consumeFuel() {
        burnTimeRemaining = ForgeHooks.getBurnTime(this.inventory.getStackInSlot(FUEL_ID));
        this.inventory.decrStackSize(FUEL_ID, 1);
        currentMaxBurnTime = burnTimeRemaining;
        System.out.println(currentMaxBurnTime);
    }

    public void setCustomName(ITextComponent name) {
        this.customName = name;
    }

    public ITextComponent getName() {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    public ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + IndustrialMetallurgy.MOD_ID + ".thermoelectric_generator");
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
        this.burnTimeRemaining = nbt.getInt("BurnTimeRemaining");
        this.energy = nbt.getInt("Energy");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (this.customName != null) {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
        }
        ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
        compound.putInt("BurnTimeRemaining", this.burnTimeRemaining);
        compound.putInt("Energy", this.energy);
        return compound;
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
        return 0;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int result = (this.energy >= maxExtract) ? maxExtract : this.energy;
        if (!simulate && result > 0)
            this.energy -= result;
        return result;
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
        return (energy > 0);
    }

    @Override
    public boolean canReceive() {
        return false;
    }
}
