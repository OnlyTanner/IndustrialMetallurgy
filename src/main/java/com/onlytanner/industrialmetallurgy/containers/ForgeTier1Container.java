package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier1TileEntity;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public class ForgeTier1Container extends Container {

    protected final ForgeTier1TileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    protected Map<ContainerElementDimension.ElementType, Vector<ContainerElementDimension>> containerSlots;

    public ForgeTier1Container(final int id, final PlayerInventory player, final ForgeTier1TileEntity tileEntity) {
        super(ModContainerTypes.FORGE_TIER1.get(), id);
        this.te = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        initContainerElements();
    }

    public ForgeTier1Container(final int id, final PlayerInventory player, final PacketBuffer data) {
        super(ModContainerTypes.FORGE_TIER1.get(), id);
        this.te = getTileEntity(player, data);
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        initContainerElements();
    }

    private static ForgeTier1TileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ForgeTier1TileEntity)
            return (ForgeTier1TileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    protected void attachSlotsToContainer() {
        for (ContainerElementDimension.ElementType type : ContainerElementDimension.ElementType.values()) {
            if (containerSlots.containsKey(type)) {
                for (ContainerElementDimension elem : containerSlots.get(type)) {
                    if (elem.isSlot) {
                        this.addSlot(new Slot(te, elem.index, elem.x, elem.y));
                    }
                }
            }
        }
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

    protected final void initContainerElements() {
        int index = 0;
        containerSlots.put(ContainerElementDimension.ElementType.FUEL, new Vector<>());
        containerSlots.put(ContainerElementDimension.ElementType.OUTPUT, new Vector<>());
        containerSlots.put(ContainerElementDimension.ElementType.INPUT, new Vector<>());
        containerSlots.put(ContainerElementDimension.ElementType.PLAYER_INVENTORY, new Vector<>());
        // Player Hotbar
        for (int i = 0; i < 9; i++) {
            containerSlots.get(ContainerElementDimension.ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8, 142 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.PLAYER_INVENTORY, true));
        }
        // Player Inventory
        int invX = 8, invY = 84, hotbarX = 8, hotbarY = 142;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                containerSlots.get(ContainerElementDimension.ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8 + (18*j), 84 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.PLAYER_INVENTORY, true));
            }
        }
        // Forge Slots
        containerSlots.get(ContainerElementDimension.ElementType.FUEL).add(new ContainerElementDimension(17, 32, 16, 16, index++, ContainerElementDimension.ElementType.FUEL, true));
        containerSlots.get(ContainerElementDimension.ElementType.OUTPUT).add(new ContainerElementDimension(127, 35, 16, 16, index++, ContainerElementDimension.ElementType.OUTPUT, true));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                containerSlots.get(ContainerElementDimension.ElementType.INPUT).add(new ContainerElementDimension(55 + (18*j), 17 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.INPUT, true));
            }
        }
        // Attach all slot elements to the parent Container object
        attachSlotsToContainer();
    }

}
