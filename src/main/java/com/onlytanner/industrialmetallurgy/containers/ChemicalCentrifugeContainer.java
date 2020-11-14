package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ChemicalCentrifugeTileEntity;
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

public class ChemicalCentrifugeContainer extends Container {

    public final ChemicalCentrifugeTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    public FunctionalIntReferenceHolder currentSmeltTime;
    public FunctionalIntReferenceHolder currentEnergy;
    public FunctionalIntReferenceHolder acidLevel;
    protected Map<ElementType, Vector<ContainerElementDimension>> containerSlots;
    private PlayerInventory inventory;
    public Slot outputSlot, inputSlot, acidSlot;

    public ChemicalCentrifugeContainer(final int id, final PlayerInventory player, final ChemicalCentrifugeTileEntity tileEntity) {
        super(ModContainerTypes.CHEMICAL_CENTRIFUGE.get(), id);
        this.te = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        this.inventory = player;
        initContainerElements();
        this.trackInt(currentSmeltTime = new FunctionalIntReferenceHolder(() -> this.te.currentSmeltTime, value -> this.te.currentSmeltTime = value));
        this.trackInt(currentEnergy = new FunctionalIntReferenceHolder(() -> this.te.energy, value -> this.te.energy = value));
        this.trackInt(acidLevel = new FunctionalIntReferenceHolder(() -> this.te.acidLevel, value -> this.te.acidLevel = value));
    }

    public ChemicalCentrifugeContainer(final int id, final PlayerInventory player, final PacketBuffer data) {
        this(id, player, getTileEntity(player, data));
    }

    private static ChemicalCentrifugeTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "playerInv cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ChemicalCentrifugeTileEntity) {
            return (ChemicalCentrifugeTileEntity) tileAtPos;
        }
        throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.CHEMICAL_CENTRIFUGE.get());
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
    public int getSmeltProgressionScaled() {
        return this.currentSmeltTime.get() != 0 && this.te.MAX_SMELT_TIME != 0
                ? this.currentSmeltTime.get() * 24 / this.te.MAX_SMELT_TIME
                : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getCurrentEnergyScaled() {
        return this.currentEnergy.get() != 0 && this.te.MAX_ENERGY != 0
                ? this.currentEnergy.get() * 70 / this.te.MAX_ENERGY
                : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getAcidLevelScaled() {
        return this.acidLevel.get() != 0 && this.te.MAX_ACID_LEVEL != 0
                ? this.acidLevel.get() * 28 / this.te.MAX_ACID_LEVEL
                : 0;
    }

    protected final void initContainerElements() {
        int index = 0;
        containerSlots.put(ElementType.UTILITY, new Vector<>());
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
        // ChemicalCentrifuge Slots
        containerSlots.get(ElementType.INPUT).add(new ContainerElementDimension(56, 35, 16, 16, index++, ElementType.INPUT, true));
        containerSlots.get(ElementType.OUTPUT).add(new ContainerElementDimension(116, 35, 16, 16, index++, ElementType.OUTPUT, true));
        containerSlots.get(ElementType.UTILITY).add(new ContainerElementDimension(152, 62, 16, 16, index++, ElementType.UTILITY, true));
        // Attach all slot elements to the parent Container object
        attachSlotsToContainer();
    }

    protected void attachSlotsToContainer() {
        for (ElementType type : ElementType.values()) {
            if (containerSlots.containsKey(type)) {
                for (ContainerElementDimension elem : containerSlots.get(type)) {
                    if (elem.isSlot) {
                        if (elem.type == ElementType.PLAYER_INVENTORY) {
                            this.addSlot(new Slot(inventory, elem.index, elem.x, elem.y));
                        }
                        else if (elem.type == ElementType.UTILITY) {
                            ChemicalCentrifugeAcidSlot a = new ChemicalCentrifugeAcidSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.acidSlot = a;
                            this.addSlot(acidSlot);
                        }
                        else if (elem.type == ElementType.OUTPUT) {
                            ChemicalCentrifugeOutputSlot o = new ChemicalCentrifugeOutputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.outputSlot = o;
                            this.addSlot(outputSlot);
                        }
                        else if (elem.type == ElementType.INPUT) {
                            ChemicalCentrifugeInputSlot i = new ChemicalCentrifugeInputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.inputSlot = i;
                            this.addSlot(inputSlot);
                        }
                    }
                }
            }
        }
    }

    public class ChemicalCentrifugeAcidSlot extends SlotItemHandler {

        public ChemicalCentrifugeAcidSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return (stack.getItem().equals(RegistryHandler.SULFURIC_ACID_BOTTLE.get()));
        }

    }

    public class ChemicalCentrifugeOutputSlot extends SlotItemHandler {

        public ChemicalCentrifugeOutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return false;
        }

    }

    public class ChemicalCentrifugeInputSlot extends SlotItemHandler {

        public ChemicalCentrifugeInputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return true;
        }

    }

}