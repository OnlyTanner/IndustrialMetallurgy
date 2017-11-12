package com.onlytanner.test.handler;

import com.onlytanner.test.container.ContainerForgeTier1;
import com.onlytanner.test.gui.GuiForgeTier1;
import com.onlytanner.test.tileentities.TileEntityForgeTier1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerForgeTier1 implements IGuiHandler
{
	private static final int GUI_ID = 32;
	public static int getGuiID() {return GUI_ID;}

	// Gets the server side element for the given gui id this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityForgeTier1) {
			TileEntityForgeTier1 tileInventoryFurnace = (TileEntityForgeTier1) tileEntity;
			return new ContainerForgeTier1(player.inventory, tileInventoryFurnace);
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
		if (tileEntity instanceof TileEntityForgeTier1) {
			TileEntityForgeTier1 tileInventoryFurnace = (TileEntityForgeTier1) tileEntity;
			return new GuiForgeTier1(player.inventory, tileInventoryFurnace);
		}
		return null;
	}
}