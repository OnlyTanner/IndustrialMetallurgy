/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlytanner.industrialmetallurgy.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

/**
 *
 * @author Tanner Lisonbee
 */
public interface IEnergyReceiver
{
    int getEnergyStored();
    boolean doesReceiveEnergy();
    EnumFacing[] getEnergyReceiveSides();
    boolean canReceiveFrom(TileEntity entity);
    ModEnergyStorage getStorage();
}
