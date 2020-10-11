package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.tileentities.ModTileEntityBase;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public abstract class ModContainerBase extends Container {

    protected final ModTileEntityBase te;
    private final IWorldPosCallable canInteractWithCallable;
    protected Map<ContainerElementDimension.ElementType, Vector<ContainerElementDimension>> containerSlots;

    protected ModContainerBase(final int id, final PlayerInventory player, final ModTileEntityBase te, ContainerType<?> type) {
        super(type, id);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
    }

    protected abstract void initContainerElements();

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }

    protected void attachSlotsToContainer() {
        for (ContainerElementDimension.ElementType type : ContainerElementDimension.ElementType.values()) {
            for (ContainerElementDimension elem : containerSlots.get(type)) {
                if (elem.isSlot) {
                    this.addSlot(new Slot(te, elem.index, elem.x, elem.y));
                }
            }
        }
    }

    protected static ModTileEntityBase getTileEntity(final PlayerInventory inv, final PacketBuffer data) {
        Objects.requireNonNull(inv, "Player Inventory cannot be null");
        Objects.requireNonNull(data, "Packet Buffer Data cannot be null");
        final TileEntity tileAtPos = inv.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ModTileEntityBase) {
            return (ModTileEntityBase) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct: " + tileAtPos);
    }

    public ItemStack transferStackInSlot(PlayerEntity player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack other = slot.getStack();
            stack = other.copy();
            if (index < 7) {
                if (!this.mergeItemStack(other, 7, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(other, 0, 7, false)) {
                return ItemStack.EMPTY;
            }
            if (other.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }
        }
        return stack;
    }

}
