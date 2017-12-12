package com.onlytanner.industrialmetallurgy.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

/**
 *
 * @author Tanner Lisonbee
 */
public interface IEnergyProvider
{
    int getEnergyToSplitShare();
    boolean doesShareEnergy();
    EnumFacing[] getEnergyShareSides();
    boolean canShareTo(TileEntity entity);
    ModEnergyStorage getStorage();
}
