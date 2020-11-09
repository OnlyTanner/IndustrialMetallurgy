package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier1TileEntity;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension.ElementType;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.*;

public class ForgeTier1Container extends Container {

    protected final ForgeTier1TileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    protected Map<ContainerElementDimension.ElementType, Vector<ContainerElementDimension>> containerSlots;
    private PlayerInventory inventory;
    public Slot fuelSlot, outputSlot;
    public Slot[] inputSlots;
    public static final int FUEL_ID = 6;
    public static final int OUTPUT_ID = 7;

    public ForgeTier1Container(final int id, final PlayerInventory player, final ForgeTier1TileEntity tileEntity) {
        super(ModContainerTypes.FORGE_TIER1.get(), id);
        this.te = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        this.inventory = player;
        this.inputSlots = new ForgeInputSlot[6];
        initContainerElements();
    }

    public ForgeTier1Container(final int id, final PlayerInventory player, final PacketBuffer data) {
        this(id, player, getTileEntity(player, data));
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

    protected final void initContainerElements() {
        int index = 0;
        containerSlots.put(ElementType.FUEL, new Vector<>());
        containerSlots.put(ElementType.OUTPUT, new Vector<>());
        containerSlots.put(ElementType.INPUT, new Vector<>());
        containerSlots.put(ElementType.PLAYER_INVENTORY, new Vector<>());
        // Player Hotbar
        for (int i = 0; i < 9; i++) {
            containerSlots.get(ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8 + (18*i), 142, 16, 16, index++, ElementType.PLAYER_INVENTORY, true));
        }
        // Player Inventory
        int invX = 8, invY = 84, hotbarX = 8, hotbarY = 142;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                containerSlots.get(ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8 + (18*j), 84 + (18*i), 16, 16, index++, ElementType.PLAYER_INVENTORY, true));
            }
        }
        index = 0;
        // Forge Slots
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                containerSlots.get(ContainerElementDimension.ElementType.INPUT).add(new ContainerElementDimension(55 + (18*j), 17 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.INPUT, true));
            }
        }
        containerSlots.get(ElementType.FUEL).add(new ContainerElementDimension(17, 35, 16, 16, index++, ElementType.FUEL, true));
        containerSlots.get(ContainerElementDimension.ElementType.OUTPUT).add(new ContainerElementDimension(127, 35, 16, 16, index++, ContainerElementDimension.ElementType.OUTPUT, true));
        // Attach all slot elements to the parent Container object
        attachSlotsToContainer();
    }

    protected void attachSlotsToContainer() {
        int inputSlotIndex = 0;
        for (ContainerElementDimension.ElementType type : ContainerElementDimension.ElementType.values()) {
            if (containerSlots.containsKey(type)) {
                for (ContainerElementDimension elem : containerSlots.get(type)) {
                    if (elem.isSlot) {
                        if (elem.type == ElementType.PLAYER_INVENTORY) {
                            this.addSlot(new Slot(inventory, elem.index, elem.x, elem.y));
                        }
                        else if (elem.type == ElementType.FUEL) {
                            ForgeFuelSlot f = new ForgeFuelSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            f.putStack(te.teContents[FUEL_ID]);
                            this.fuelSlot = f;
                            this.addSlot(fuelSlot);
                        }
                        else if (elem.type == ElementType.OUTPUT) {
                            ForgeOutputSlot o = new ForgeOutputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            o.putStack(te.teContents[OUTPUT_ID]);
                            this.outputSlot = o;
                            this.addSlot(outputSlot);
                        }
                        else if (elem.type == ElementType.INPUT) {
                            ForgeInputSlot i = new ForgeInputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            i.putStack(te.teContents[inputSlotIndex]);
                            this.inputSlots[inputSlotIndex] = i;
                            this.addSlot(inputSlots[inputSlotIndex++]);
                        }
                    }
                }
            }
        }
    }

    private ItemStack[] getContainerItemStacks() {
        ItemStack[] slots = new ItemStack[8];
        for (int i = 0; i < 6; i++)
            slots[i] = inputSlots[i].getStack();
        slots[FUEL_ID] = fuelSlot.getStack();
        slots[OUTPUT_ID] = outputSlot.getStack();
        return slots;
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int index) {
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
        updateSlotContents();
        return returnStack;
    }

    private void updateSlotContents() {
        ItemStack[] stacks = getContainerItemStacks();
        for (int i = 0; i < stacks.length; i++) {
            te.teContents[i] = stacks[i];
        }
    }

    @OnlyIn(Dist.CLIENT)
    public int getSmeltProgressionScaled() {
        return this.te.currentSmeltTime != 0 && this.te.maxSmeltTime != 0 ? this.te.currentSmeltTime * 24 / this.te.maxSmeltTime : 0;
    }

    public class ForgeFuelSlot extends SlotItemHandler {

        public ForgeFuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return (stack.getItem().equals(RegistryHandler.COAL_COKE.get()));
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
