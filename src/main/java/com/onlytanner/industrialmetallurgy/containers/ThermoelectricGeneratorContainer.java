package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ThermoelectricGeneratorTileEntity;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension.ElementType;
import com.onlytanner.industrialmetallurgy.util.FunctionalIntReferenceHolder;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public class ThermoelectricGeneratorContainer extends Container {

    protected final ThermoelectricGeneratorTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    public FunctionalIntReferenceHolder burnTimeRemaining;
    public FunctionalIntReferenceHolder currentEnergy;
    public FunctionalIntReferenceHolder currentMaxBurnTime;
    protected Map<ContainerElementDimension.ElementType, Vector<ContainerElementDimension>> containerSlots;
    private PlayerInventory inventory;
    public Slot fuelSlot;
    public Slot[] extraFuelSlots;

    public ThermoelectricGeneratorContainer(final int id, final PlayerInventory player, final ThermoelectricGeneratorTileEntity tileEntity) {
        super(ModContainerTypes.THERMOELECTRIC_GENERATOR.get(), id);
        this.te = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        this.inventory = player;
        extraFuelSlots = new Slot[4];
        initContainerElements();
        this.trackInt(burnTimeRemaining = new FunctionalIntReferenceHolder(() -> this.te.burnTimeRemaining, value -> this.te.burnTimeRemaining = value));
        this.trackInt(currentEnergy = new FunctionalIntReferenceHolder(() -> this.te.energy, value -> this.te.energy = value));
        this.trackInt(currentMaxBurnTime = new FunctionalIntReferenceHolder(() -> this.te.currentMaxBurnTime, value -> this.te.currentMaxBurnTime = value));
    }

    public ThermoelectricGeneratorContainer(final int id, final PlayerInventory player, final PacketBuffer data) {
        this(id, player, getTileEntity(player, data));
    }

    private static ThermoelectricGeneratorTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "playerInv cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ThermoelectricGeneratorTileEntity) {
            return (ThermoelectricGeneratorTileEntity) tileAtPos;
        }
        throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.THERMOELECTRIC_GENERATOR.get());
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            final ItemStack slotStack = slot.getStack();
            returnStack = slotStack.copy();

            final int containerSlots = this.inventorySlots.size() - player.inventory.mainInventory.size();
            if (index < containerSlots) {
                if (!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(slotStack, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (slotStack.getCount() == returnStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return returnStack;
    }

    @OnlyIn(Dist.CLIENT)
    public int getCurrentEnergyScaled() {
        return this.currentEnergy.get() != 0 && this.te.MAX_ENERGY != 0
                ? this.currentEnergy.get() * 70 / this.te.MAX_ENERGY
                : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getBurnTimeScaled() {
        return this.burnTimeRemaining.get() != 0 && this.currentMaxBurnTime.get() != 0
                ? this.burnTimeRemaining.get() * 14 / this.currentMaxBurnTime.get()
                : 0;
    }

    protected final void initContainerElements() {
        int index = 0;
        containerSlots.put(ElementType.PLAYER_INVENTORY, new Vector<>());
        containerSlots.put(ElementType.FUEL, new Vector<>());
        containerSlots.put(ElementType.UTILITY, new Vector<>());
        // Player Hotbar
        for (int i = 0; i < 9; i++) {
            containerSlots.get(ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8 + (18*i), 142, 16, 16, index++, ElementType.PLAYER_INVENTORY, true));
        }
        // Player Inventory
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                containerSlots.get(ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8 + (18*j), 84 + (18*i), 16, 16, index++, ElementType.PLAYER_INVENTORY, true));
            }
        }
        index = 0;
        // Crusher Slots
        containerSlots.get(ElementType.FUEL).add(new ContainerElementDimension(80, 35, 16, 16, index++, ElementType.FUEL, true));
        containerSlots.get(ElementType.UTILITY).add(new ContainerElementDimension(8, 8, 16, 16, index++, ElementType.UTILITY, true));
        containerSlots.get(ElementType.UTILITY).add(new ContainerElementDimension(8, 26, 16, 16, index++, ElementType.UTILITY, true));
        containerSlots.get(ElementType.UTILITY).add(new ContainerElementDimension(8, 44, 16, 16, index++, ElementType.UTILITY, true));
        containerSlots.get(ElementType.UTILITY).add(new ContainerElementDimension(8, 62, 16, 16, index++, ElementType.UTILITY, true));
        // Attach all slot elements to the parent Container object
        attachSlotsToContainer();
    }

    protected void attachSlotsToContainer() {
        int extraFuelSlotIndex = 0;
        for (ContainerElementDimension.ElementType type : ContainerElementDimension.ElementType.values()) {
            if (containerSlots.containsKey(type)) {
                for (ContainerElementDimension elem : containerSlots.get(type)) {
                    if (elem.isSlot) {
                        if (elem.type == ElementType.PLAYER_INVENTORY) {
                            this.addSlot(new Slot(inventory, elem.index, elem.x, elem.y));
                        }
                        else if (elem.type == ElementType.FUEL) {
                            TGFuelSlot f = new TGFuelSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.fuelSlot = f;
                            this.addSlot(fuelSlot);
                        }
                        else if (elem.type == ElementType.UTILITY) {
                            TGFuelSlot f = new TGFuelSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.extraFuelSlots[extraFuelSlotIndex++] = f;
                            this.addSlot(f);
                        }
                    }
                }
            }
        }
    }

    public class TGFuelSlot extends SlotItemHandler {

        public TGFuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return (AbstractFurnaceTileEntity.isFuel(stack) || stack.getItem().equals(RegistryHandler.COAL_COKE));
        }

    }

}
