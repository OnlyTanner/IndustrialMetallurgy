package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.containers.ModContainerBase;
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

public class ModTileEntityBase extends LockableLootTileEntity implements ITickableTileEntity, ISidedInventory {

    private ModContainerBase container;

    public ModTileEntityBase(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        container = null;
    }

    public ModTileEntityBase(TileEntityType<?> tileEntityTypeIn, ModContainerBase container) {
        super(tileEntityTypeIn);
        this.container = container;
    }

    public ModContainerBase getContainer() {
        return this.container;
    }

    public void setContainer(ModContainerBase container) {
        this.container = container;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return null;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {

    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public void tick() {

    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return false;
    }
}
