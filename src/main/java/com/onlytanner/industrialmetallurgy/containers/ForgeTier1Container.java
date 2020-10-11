package com.onlytanner.industrialmetallurgy.containers;

import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.tileentities.ForgeTier1TileEntity;
import com.onlytanner.industrialmetallurgy.tileentities.ModTileEntityBase;
import com.onlytanner.industrialmetallurgy.util.ContainerElementDimension;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

import java.util.Vector;

public class ForgeTier1Container extends ModContainerBase {

    public ForgeTier1Container(final int id, final PlayerInventory player, final ForgeTier1TileEntity forgeTier1TileEntity) {
        super(id, player, forgeTier1TileEntity, ModContainerTypes.FORGE_TIER1.get());
        initContainerElements();
    }

    public ForgeTier1Container(final int id, final PlayerInventory player, final PacketBuffer data) {
        super(id, player, getTileEntity(player, data), getTileEntity(player, data).getContainer().getType());
        initContainerElements();
    }

    @Override
    protected final void initContainerElements() {
        int index = 0;
        super.containerSlots.put(ContainerElementDimension.ElementType.FUEL, new Vector<>());
        super.containerSlots.put(ContainerElementDimension.ElementType.OUTPUT, new Vector<>());
        super.containerSlots.put(ContainerElementDimension.ElementType.INPUT, new Vector<>());
        super.containerSlots.put(ContainerElementDimension.ElementType.PLAYER_INVENTORY, new Vector<>());
        // Forge Slots
        super.containerSlots.get(ContainerElementDimension.ElementType.FUEL).add(new ContainerElementDimension(17, 32, 16, 16, index++, ContainerElementDimension.ElementType.FUEL, true));
        super.containerSlots.get(ContainerElementDimension.ElementType.OUTPUT).add(new ContainerElementDimension(127, 35, 16, 16, index++, ContainerElementDimension.ElementType.OUTPUT, true));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                super.containerSlots.get(ContainerElementDimension.ElementType.INPUT).add(new ContainerElementDimension(55 + (18*j), 17 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.INPUT, true));
            }
        }
        // Player Inventory
        int invX = 8, invY = 84, hotbarX = 8, hotbarY = 142;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                super.containerSlots.get(ContainerElementDimension.ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8 + (18*j), 84 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.PLAYER_INVENTORY, true));
            }
        }
        // Player Hotbar
        for (int i = 0; i < 9; i++) {
            super.containerSlots.get(ContainerElementDimension.ElementType.PLAYER_INVENTORY).add(new ContainerElementDimension(8, 142 + (18*i), 16, 16, index++, ContainerElementDimension.ElementType.PLAYER_INVENTORY, true));
        }
        // Attach all slot elements to the parent Container object
        super.attachSlotsToContainer();
    }

}
