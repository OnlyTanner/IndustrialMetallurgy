package com.onlytanner.industrialmetallurgy.tileentities;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public abstract class ModTileEntityBase extends LockableLootTileEntity implements ITickableTileEntity, ISidedInventory {

    private Container container;

    public ModTileEntityBase(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        container = null;
    }

    public ModTileEntityBase(TileEntityType<?> tileEntityTypeIn, Container container) {
        super(tileEntityTypeIn);
        this.container = container;
    }

    public Container getContainer() {
        return this.container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    protected abstract ITextComponent getDefaultName();

    @Override
    protected abstract Container createMenu(int id, PlayerInventory player);

    @Override
    protected abstract NonNullList<ItemStack> getItems();

    @Override
    protected abstract void setItems(NonNullList<ItemStack> itemsIn);

    @Override
    public abstract int getSizeInventory();

    @Override
    public abstract void tick();

    @Override
    public abstract int[] getSlotsForFace(Direction side);

    @Override
    public abstract boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction);

    @Override
    public abstract boolean canExtractItem(int index, ItemStack stack, Direction direction);
}
