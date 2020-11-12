package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.CrusherTileEntity;
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

public class CrusherContainer extends Container {

    public final CrusherTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    public FunctionalIntReferenceHolder currentSmeltTime;
    public FunctionalIntReferenceHolder currentEnergy;
    public FunctionalIntReferenceHolder acidLevel;
    protected Map<ContainerElementDimension.ElementType, Vector<ContainerElementDimension>> containerSlots;
    private PlayerInventory inventory;
    public Slot burrSlot, outputSlot, inputSlot, acidSlot;

    public CrusherContainer(final int id, final PlayerInventory player, final CrusherTileEntity tileEntity) {
        super(ModContainerTypes.CRUSHER.get(), id);
        this.te = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        this.containerSlots = new HashMap<>();
        this.inventory = player;
        initContainerElements();
        this.trackInt(currentSmeltTime = new FunctionalIntReferenceHolder(() -> this.te.currentSmeltTime, value -> this.te.currentSmeltTime = value));
        this.trackInt(currentEnergy = new FunctionalIntReferenceHolder(() -> this.te.energy, value -> this.te.energy = value));
        this.trackInt(acidLevel = new FunctionalIntReferenceHolder(() -> this.te.acidLevel, value -> this.te.acidLevel = value));
    }

    public CrusherContainer(final int id, final PlayerInventory player, final PacketBuffer data) {
        this(id, player, getTileEntity(player, data));
    }

    private static CrusherTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "playerInv cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof CrusherTileEntity) {
            return (CrusherTileEntity) tileAtPos;
        }
        throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.CRUSHER.get());
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
        containerSlots.put(ElementType.FUEL, new Vector<>());
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
        // Crusher Slots
        containerSlots.get(ContainerElementDimension.ElementType.INPUT).add(new ContainerElementDimension(56, 35, 16, 16, index++, ContainerElementDimension.ElementType.INPUT, true));
        containerSlots.get(ElementType.FUEL).add(new ContainerElementDimension(152, 8, 16, 16, index++, ElementType.FUEL, true));
        containerSlots.get(ContainerElementDimension.ElementType.OUTPUT).add(new ContainerElementDimension(116, 35, 16, 16, index++, ContainerElementDimension.ElementType.OUTPUT, true));
        containerSlots.get(ElementType.UTILITY).add(new ContainerElementDimension(152, 62, 16, 16, index++, ElementType.UTILITY, true));
        // Attach all slot elements to the parent Container object
        attachSlotsToContainer();
    }

    protected void attachSlotsToContainer() {
        for (ContainerElementDimension.ElementType type : ContainerElementDimension.ElementType.values()) {
            if (containerSlots.containsKey(type)) {
                for (ContainerElementDimension elem : containerSlots.get(type)) {
                    if (elem.isSlot) {
                        if (elem.type == ElementType.PLAYER_INVENTORY) {
                            this.addSlot(new Slot(inventory, elem.index, elem.x, elem.y));
                        }
                        else if (elem.type == ElementType.FUEL) {
                            CrusherBurrSlot f = new CrusherBurrSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.burrSlot = f;
                            this.addSlot(burrSlot);
                        }
                        else if (elem.type == ElementType.UTILITY) {
                            CrusherAcidSlot a = new CrusherAcidSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.acidSlot = a;
                            this.addSlot(acidSlot);
                        }
                        else if (elem.type == ElementType.OUTPUT) {
                            CrusherOutputSlot o = new CrusherOutputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.outputSlot = o;
                            this.addSlot(outputSlot);
                        }
                        else if (elem.type == ElementType.INPUT) {
                            CrusherInputSlot i = new CrusherInputSlot(this.te.getInventory(), elem.index, elem.x, elem.y);
                            this.inputSlot = i;
                            this.addSlot(inputSlot);
                        }
                    }
                }
            }
        }
    }

    public class CrusherBurrSlot extends SlotItemHandler {

        public CrusherBurrSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return (stack.getItem().equals(RegistryHandler.BRASS_BURR_SET.get()) ||
                    stack.getItem().equals(RegistryHandler.STEEL_BURR_SET.get()) ||
                    stack.getItem().equals(RegistryHandler.CHROMIUM_BURR_SET.get()) ||
                    stack.getItem().equals(RegistryHandler.TUNGSTEN_CARBIDE_BURR_SET.get()) ||
                    stack.getItem().equals(RegistryHandler.NEQUITUM_BURR_SET.get()));
        }

    }

    public class CrusherAcidSlot extends SlotItemHandler {

        public CrusherAcidSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return (stack.getItem().equals(RegistryHandler.SULFURIC_ACID_BOTTLE.get()));
        }

    }

    public class CrusherOutputSlot extends SlotItemHandler {

        public CrusherOutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return false;
        }

    }

    public class CrusherInputSlot extends SlotItemHandler {

        public CrusherInputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return true;
        }

    }

}
