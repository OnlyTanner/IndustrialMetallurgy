package com.onlytanner.industrialmetallurgy.handler;

import com.onlytanner.industrialmetallurgy.container.ContainerChemicalSeparator;
import com.onlytanner.industrialmetallurgy.gui.GuiChemicalSeparator;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityChemicalSeparator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerChemicalSeparator implements IGuiHandler {

    private static final int GUI_ID = 38;

    public static int getGuiID() {
        return GUI_ID;
    }

    // Gets the server side element for the given gui id this should return a container
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileEntityChemicalSeparator) {
            TileEntityChemicalSeparator tileInventoryFurnace = (TileEntityChemicalSeparator) tileEntity;
            return new ContainerChemicalSeparator(player.inventory, tileInventoryFurnace);
        }
        return null;
    }

    // Gets the client side element for the given gui id this should return a gui
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileEntityChemicalSeparator) {
            TileEntityChemicalSeparator tileInventoryFurnace = (TileEntityChemicalSeparator) tileEntity;
            return new GuiChemicalSeparator(player.inventory, tileInventoryFurnace);
        }
        return null;
    }
}
