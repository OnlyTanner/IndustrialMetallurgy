package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier2TileEntity;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier3TileEntity;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class ForgeTier3Container extends AdvancedForgeContainer {

    public ForgeTier3Container(int id, PlayerInventory player, ForgeTier3TileEntity tileEntity) {
        super(id, player, tileEntity, ModContainerTypes.FORGE_TIER3.get());
    }

    public ForgeTier3Container(int id, PlayerInventory player, PacketBuffer data) {
        this(id, player, (ForgeTier3TileEntity) getTileEntity(player, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.FORGE_TIER3.get());
    }

}
