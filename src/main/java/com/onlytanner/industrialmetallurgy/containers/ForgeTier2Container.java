package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier2TileEntity;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class ForgeTier2Container extends BasicForgeContainer {

    public ForgeTier2Container(int id, PlayerInventory player, ForgeTier2TileEntity tileEntity) {
        super(id, player, tileEntity, ModContainerTypes.FORGE_TIER2.get());
    }

    public ForgeTier2Container(int id, PlayerInventory player, PacketBuffer data) {
        this(id, player, (ForgeTier2TileEntity) getTileEntity(player, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.FORGE_TIER2.get());
    }

}
