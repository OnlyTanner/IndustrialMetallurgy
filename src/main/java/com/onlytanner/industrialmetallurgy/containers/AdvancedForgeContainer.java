package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.tileentity.AdvancedForgeTileEntity;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension.ElementType;
import com.onlytanner.industrialmetallurgy.util.FunctionalIntReferenceHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
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

public abstract class AdvancedForgeContainer extends Container {

    public final AdvancedForgeTileEntity te;
    protected final IWorldPosCallable canInteractWithCallable;
    public FunctionalIntReferenceHolder currentSmeltTime;
    public FunctionalIntReferenceHolder currentEnergy;
    public FunctionalIntReferenceHolder currentTemperature;
    protected Map<ElementType, Vector<ContainerElementDimension>> containerSlots;
    protected PlayerInventory inventory;
    public Slot outputSlot;
    public Slot[] inputSlots;

    public AdvancedForgeContainer(final int id, final PlayerInventory player, final AdvancedForgeTileEntity tileEntity, ContainerType<?> type) {
        super(type, id);
        this.te = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        this.inventory = player;
        this.inputSlots = new ForgeInputSlot[4];
        initContainerElements();
        this.trackInt(currentSmeltTime = new FunctionalIntReferenceHolder(() -> this.te.currentSmeltTime, value -> this.te.currentSmeltTime = value));
        this.trackInt(currentEnergy = new FunctionalIntReferenceHolder(() -> this.te.energy, value -> this.te.energy = value));
        this.trackInt(currentTemperature = new FunctionalIntReferenceHolder(() -> this.te.currentTemperature, value -> this.te.currentTemperature = value));
    }

    protected static AdvancedForgeTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "playerInv cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof AdvancedForgeTileEntity) {
            return (AdvancedForgeTileEntity) tileAtPos;
        }
        throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
    }

    @Override
    public abstract boolean canInteractWith(PlayerEntity playerIn);

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
    public int getSmeltProgressionScaled() {
        return this.currentSmeltTime.get() != 0 && this.te.maxSmeltTime != 0
                ? this.currentSmeltTime.get() * 24 / this.te.maxSmeltTime
                : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getCurrentEnergyScaled() {
        return this.currentEnergy.get() != 0 && this.te.MAX_ENERGY != 0
                ? this.currentEnergy.get() * 70 / this.te.MAX_ENERGY
                : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getTemperatureScaled() {
        return this.currentTemperature.get() != 0 && this.te.maxTemperature != 0
                ? this.currentTemperature.get() * 73 / this.te.maxTemperature
                : 0;
    }

    protected final void initContainerElements() {
        int index = 0;
        containerSlots.put(ElementType.OUTPUT, new Vector<>());
        containerSlots.put(ElementType.INPUT, new Vector<>());
        containerSlots.put(ElementType.PLAYER_INVENTORY, new Vector<>());
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
        // Forge Slots
        containerSlots.get(ElementType.INPUT).add(new ContainerElementDimension(47, 22, 16, 16, index++, ElementType.INPUT, true));
        containerSlots.get(ElementType.INPUT).add(new ContainerElementDimension(73, 22, 16, 16, index++, ElementType.INPUT, true));
        containerSlots.get(ElementType.INPUT).add(new ContainerElementDimension(47, 48, 16, 16, index++, ElementType.INPUT, true));
        containerSlots.get(ElementType.INPUT).add(new ContainerElementDimension(73, 48, 16, 16, index++, ElementType.INPUT, true));
        containerSlots.get(ElementType.OUTPUT).add(new ContainerElementDimension(127, 35, 16, 16, index++, ElementType.OUTPUT, true));
        // Attach all slot elements to the parent Container object
        attachSlotsToContainer();
    }

    protected void attachSlotsToContainer() {
        int inputSlotIndex = 0;
        for (ElementType type : ElementType.values()) {
            if (containerSlots.containsKey(type)) {
                for (ContainerElementDimension elem : containerSlots.get(type)) {
                    if (elem.isSlot) {
                        if (elem.type == ElementType.PLAYER_INVENTORY) {
                            this.addSlot(new Slot(inventory, elem.index, elem.x, elem.y));
                        }
                        else if (elem.type == ElementType.OUTPUT) {
                            ForgeOutputSlot o = new ForgeOutputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.outputSlot = o;
                            this.addSlot(outputSlot);
                        }
                        else if (elem.type == ElementType.INPUT) {
                            ForgeInputSlot i = new ForgeInputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.inputSlots[inputSlotIndex] = i;
                            this.addSlot(inputSlots[inputSlotIndex++]);
                        }
                    }
                }
            }
        }
    }

    public class ForgeOutputSlot extends SlotItemHandler {

        public ForgeOutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return false;
        }

    }

    public class ForgeInputSlot extends SlotItemHandler {

        public ForgeInputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return true;
        }

    }

}
