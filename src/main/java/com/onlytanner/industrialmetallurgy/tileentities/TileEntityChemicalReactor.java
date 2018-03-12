package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.container.ContainerChemicalReactor;
import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityChemicalReactor extends TileEntityBase implements ITickable, IEnergyReceiver
{
    private ArrayList<ItemStack> inputs;
    public final int MAX_CAPACITY = 100000;
    public ModEnergyStorage storage = new ModEnergyStorage(MAX_CAPACITY, 0, 80);

    public TileEntityChemicalReactor()
    {
        super(3, 2, 0, 200);
        inputs = new ArrayList<ItemStack>();
        inputs.add(itemStacks[FIRST_INPUT_SLOT]);
        inputs.add(itemStacks[FIRST_INPUT_SLOT + 1]);
        inputs.add(itemStacks[FIRST_INPUT_SLOT + 2]);
    }

    @Override
    public void update()
    {
        if (this.storage.getEnergyStored() < MAX_CAPACITY)
            this.storage.receiveEnergyInternal((int) ModEnergyStorage.takeEnergyAllFaces(worldObj, pos, 1000, false), false);
        
        if (isBurning())
        {
            storage.extractEnergy(160, false);
        }
    }

    @Override
    public String getName()
    {
        return "          Chemical Reactor";
    }

    @Override
    public boolean isBurning()
    {
        return cookTime > 0;
    }
    
    @Override
    public int getField(int id)
    {
        switch (id) {
            case 0:
                return this.cookTime;
            case 1:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value)
    {
        switch (id) {
            case 0:
                this.cookTime = (short) value;
                break;
            case 1:
                this.totalCookTime = (short) value;
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound parentNBTTagCompound)
    {
        super.writeToNBT(parentNBTTagCompound); // The super call is required to save and load the tiles location

        // Save the stored item stacks
        // to use an analogy with Java, this code generates an array of hashmaps
        // The itemStack in each slot is converted to an NBTTagCompound, which is effectively a hashmap of key->value pairs such
        //   as slot=1, id=2353, count=1, etc
        // Each of these NBTTagCompound are then inserted into NBTTagList, which is similar to an array.
        NBTTagList dataForAllSlots = new NBTTagList();
        for (int i = 0; i < this.itemStacks.length; ++i)
        {
            if (this.itemStacks[i] != null)
            {
                NBTTagCompound dataForThisSlot = new NBTTagCompound();
                dataForThisSlot.setByte("Slot", (byte) i);
                this.itemStacks[i].writeToNBT(dataForThisSlot);
                dataForAllSlots.appendTag(dataForThisSlot);
            }
        }
        // the array of hashmaps is then inserted into the parent hashmap for the container
        parentNBTTagCompound.setTag("Items", dataForAllSlots);

        // Save everything else
        parentNBTTagCompound.setShort("CookTime", cookTime);
        parentNBTTagCompound.setTag("burnTimeRemaining", new NBTTagIntArray(burnTimeRemaining));
        parentNBTTagCompound.setTag("burnTimeInitial", new NBTTagIntArray(burnTimeInitialValue));
        return parentNBTTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound); // The super call is required to save and load the tiles location
        final byte NBT_TYPE_COMPOUND = 10;       // See NBTBase.createNewByType() for a listing
        NBTTagList dataForAllSlots = nbtTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

        Arrays.fill(itemStacks, null);           // set all slots to empty
        for (int i = 0; i < dataForAllSlots.tagCount(); ++i)
        {
            NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
            byte slotNumber = dataForOneSlot.getByte("Slot");
            if (slotNumber >= 0 && slotNumber < this.itemStacks.length)
            {
                this.itemStacks[slotNumber] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
            }
        }

        // Load everything else.  Trim the arrays (or pad with 0) to make sure they have the correct number of elements
        cookTime = nbtTagCompound.getShort("CookTime");
        burnTimeRemaining = Arrays.copyOf(nbtTagCompound.getIntArray("burnTimeRemaining"), FUEL_SLOTS_COUNT);
        burnTimeInitialValue = Arrays.copyOf(nbtTagCompound.getIntArray("burnTimeInitial"), FUEL_SLOTS_COUNT);
    }

    @Override
    public int getFieldCount()
    {
        return 2;
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack)
    {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerChemicalReactor(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return "industrialmetallurgy:chemical_reactor";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public int getEnergyStored()
    {
        return this.storage.getEnergyStored();
    }

    public double getFractionOfEnergyRemaining()
    {
        return (double) getEnergyStored() / (double) this.MAX_CAPACITY;
    }

    @Override
    public boolean doesReceiveEnergy()
    {
        return true;
    }

    @Override
    public EnumFacing[] getEnergyReceiveSides()
    {
        return EnumFacing.values();
    }

    @Override
    public boolean canReceiveFrom(TileEntity entity)
    {
        return true;
    }
    
    @Override
    public ModEnergyStorage getStorage()
    {
        return storage;
    }
    
    @Override
    public int getMaxCapacity()
    {
        return MAX_CAPACITY;
    }
}