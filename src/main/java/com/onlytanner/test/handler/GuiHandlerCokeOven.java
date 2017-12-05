package com.onlytanner.test.handler;

import com.onlytanner.test.container.ContainerCokeOven;
import com.onlytanner.test.gui.GuiCokeOven;
import com.onlytanner.test.tileentities.TileEntityCokeOven;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerCokeOven implements IGuiHandler {

    private static final int GUI_ID = 33;

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
        if (tileEntity instanceof TileEntityCokeOven) {
            TileEntityCokeOven tileInventoryCokeOven = (TileEntityCokeOven) tileEntity;
            return new ContainerCokeOven(player.inventory, tileInventoryCokeOven);
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
        if (tileEntity instanceof TileEntityCokeOven) {
            TileEntityCokeOven tileInventoryCokeOven = (TileEntityCokeOven) tileEntity;
            return new GuiCokeOven(player.inventory, tileInventoryCokeOven);
        }
        return null;
    }
}
