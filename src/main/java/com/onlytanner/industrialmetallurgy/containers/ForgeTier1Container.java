package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentities.ForgeTier1TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.IWorldPosCallable;

public class ForgeTier1Container extends Container {

    public final ForgeTier1TileEntity te;
    private final IWorldPosCallable canInteractWithCallable;

    public ForgeTier1Container(final int id, final PlayerInventory player, final ForgeTier1TileEntity forgeTier1TileEntity) {
        super(ModContainerTypes.FORGE_TIER1.get(), id);
        this.te = forgeTier1TileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
        // Main Inventory

    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }
}
