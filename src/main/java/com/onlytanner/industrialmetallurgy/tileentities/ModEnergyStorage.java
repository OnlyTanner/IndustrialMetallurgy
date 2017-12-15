package com.onlytanner.industrialmetallurgy.tileentities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.EnergyStorage;

/**
 *
 * @author Tanner Lisonbee
 */
public class ModEnergyStorage extends EnergyStorage 
{
    public ModEnergyStorage(int capacity, int maxReceive, int maxExtract){
        super(capacity, maxReceive, maxExtract);
    }
    
    public int extractEnergyInternal(int maxExtract, boolean simulate){
        int before = this.maxExtract;
        this.maxExtract = Integer.MAX_VALUE;

        int toReturn = this.extractEnergy(maxExtract, simulate);

        this.maxExtract = before;
        return toReturn;
    }

    public int receiveEnergyInternal(int maxReceive, boolean simulate){
        int before = this.maxReceive;
        this.maxReceive = Integer.MAX_VALUE;

        int toReturn = this.receiveEnergy(maxReceive, simulate);

        this.maxReceive = before;
        return toReturn;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate){
        if(!this.canReceive()){
            return 0;
        }
        int energy = this.getEnergyStored();

        int energyReceived = Math.min(this.capacity-energy, Math.min(this.maxReceive, maxReceive));
        if(!simulate){
            this.setEnergyStored(energy+energyReceived);
        }

        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate){
        if(!this.canExtract()){
            return 0;
        }
        int energy = this.getEnergyStored();

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if(!simulate){
            this.setEnergyStored(energy-energyExtracted);
        }
        return energyExtracted;
    }
    
    public static long giveEnergyAllFaces(World world, BlockPos pos, long energy, boolean simulate) {
        List<TileEntity> tiles = new LinkedList<TileEntity>();
        for (EnumFacing side : EnumFacing.VALUES) {
            TileEntity te = world.getTileEntity(pos.offset(side));
            if (te != null && te instanceof IEnergyReceiver)
                tiles.add(te);
        }
        
        if (tiles.size() <= 0)
            return 0;
        
        long energyPerSide = energy / tiles.size();
        long energyGiven = 0;
        for (TileEntity tile : tiles)
            if ((((IEnergyReceiver) tile).getStorage()).getEnergyStored() < ((IEnergyReceiver) tile).getMaxCapacity())
                energyGiven += ((IEnergyReceiver) tile).getStorage().receiveEnergy((int) energyPerSide, false);
            
        return energyGiven;
    }
    
    public static long takeEnergyAllFaces(World world, BlockPos pos, long energy, boolean simulate) {
        List<TileEntity> tiles = new LinkedList<TileEntity>();
        for (EnumFacing side : EnumFacing.VALUES) {
            TileEntity te = world.getTileEntity(pos.offset(side));
            if (te != null && te instanceof IEnergyProvider)
                tiles.add(te);
        }
        if (tiles.size() <= 0)
            return 0;
        
        long energyPerSide = energy / tiles.size();
        long energyGiven = 0;
        for (TileEntity tile : tiles)
            energyGiven += ((IEnergyProvider) tile).getStorage().extractEnergy((int) energyPerSide, false);
            
        return energyGiven;
    }

    public void readFromNBT(NBTTagCompound compound){
        this.setEnergyStored(compound.getInteger("Energy"));
    }

    public void writeToNBT(NBTTagCompound compound){
        compound.setInteger("Energy", this.getEnergyStored());
    }

    public void setEnergyStored(int energy){
        this.energy = energy;
    }
}
