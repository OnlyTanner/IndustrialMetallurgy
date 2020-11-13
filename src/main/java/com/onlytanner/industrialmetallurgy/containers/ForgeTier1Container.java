package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier1TileEntity;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class ForgeTier1Container extends BasicForgeContainer {

    public ForgeTier1Container(int id, PlayerInventory player, ForgeTier1TileEntity tileEntity) {
        super(id, player, tileEntity, ModContainerTypes.FORGE_TIER1.get());
    }

    public ForgeTier1Container(int id, PlayerInventory player, PacketBuffer data) {
        this(id, player, (ForgeTier1TileEntity) getTileEntity(player, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.FORGE_TIER1.get());
    }

}
