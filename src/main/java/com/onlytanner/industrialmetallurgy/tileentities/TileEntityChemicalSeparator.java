package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.blocks.BlockElectricCrusher;
import com.onlytanner.industrialmetallurgy.container.ContainerChemicalSeparator;
import com.onlytanner.industrialmetallurgy.items.crafting.SeparatorRecipes;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.block.state.IBlockState;

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
import net.minecraft.world.EnumSkyBlock;

public class TileEntityChemicalSeparator extends TileEntityBase implements ITickable, IEnergyReceiver
{
    private ArrayList<ItemStack> inputs;
    public final int MAX_CAPACITY = 100000;
    public ModEnergyStorage storage = new ModEnergyStorage(MAX_CAPACITY, 0, 80);
    private int cachedNumberOfBurningSlots = -1;
    
    public TileEntityChemicalSeparator()
    {
        super(1, 3, 0, 200);
        inputs = new ArrayList<ItemStack>();
        inputs.add(itemStacks[FIRST_INPUT_SLOT]);
        inputs.add(itemStacks[FIRST_INPUT_SLOT + 1]);
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
        
        // If there is nothing to smelt or there is no room in the output, reset cookTime and return
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (canSeparate()) {
            // If fuel is available, keep cooking the item, otherwise start "uncooking" it at double speed
            if (storage.getEnergyStored() > 0) {
                cookTime += 1;
            } else {
                cookTime -= 2;
            }

            if (cookTime < 0) {
                cookTime = 0;
            }

            // If cookTime has reached maxCookTime smelt the item and reset cookTime
            if (cookTime >= COOK_TIME_FOR_COMPLETION) {
                separateItem();
                cookTime = 0;
            }
        } else {
            cookTime = 0;
        }

        if (flag != this.isBurning()) {
            flag1 = true;
            BlockElectricCrusher.setState(this.isBurning(), this.worldObj, this.pos);
        }

        // when the number of burning slots changes, we need to force the block to re-render, otherwise the change in
        //   state will not be visible.  Likewise, we need to force a lighting recalculation.
        // The block update (for renderer) is only required on client side, but the lighting is required on both, since
        //    the client needs it for rendering and the server needs it for crop growth etc
        int numberBurning = numberOfBurningFuelSlots();
        if (cachedNumberOfBurningSlots != numberBurning) {
            cachedNumberOfBurningSlots = numberBurning;
            if (worldObj.isRemote) {
                IBlockState iblockstate = this.worldObj.getBlockState(pos);
                final int FLAGS = 3;  // I'm not sure what these flags do, exactly.
                worldObj.notifyBlockUpdate(pos, iblockstate, iblockstate, FLAGS);
            }
            worldObj.checkLightFor(EnumSkyBlock.BLOCK, pos);
        }
        if (flag1) {
            this.markDirty();
        }
    }
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item,
     * destination stack isn't full, etc.
     */
    private boolean canSeparate() 
    {
        if (this.itemStacks[FIRST_INPUT_SLOT] == null) {
            return false;
        } else {
            ArrayList<ItemStack> result = SeparatorRecipes.getInstance().getSeparatorResult(this.itemStacks[FIRST_INPUT_SLOT], this.itemStacks[FIRST_INPUT_SLOT + 1]);
            if (result == null) {
                return false;
            }
            if (this.itemStacks[FIRST_OUTPUT_SLOT] == null && this.itemStacks[FIRST_OUTPUT_SLOT + 1] == null && this.itemStacks[FIRST_OUTPUT_SLOT + 2] == null) {
                return true;
            }
            if (!result.contains(this.itemStacks[FIRST_OUTPUT_SLOT]) || !result.contains(this.itemStacks[FIRST_OUTPUT_SLOT + 1]) || !result.contains(this.itemStacks[FIRST_OUTPUT_SLOT + 2]))
                return false;
            
            int num;
            if (itemStacks[FIRST_OUTPUT_SLOT].stackSize != this.getInventoryStackLimit()) {
                num = itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.get(0).stackSize;
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize != this.getInventoryStackLimit()) {
                num = itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.get(1).stackSize;
            } else {
                num = itemStacks[FIRST_OUTPUT_SLOT + 2].stackSize + result.get(2).stackSize;
            }
            return num <= getInventoryStackLimit() && num <= this.itemStacks[FIRST_OUTPUT_SLOT].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    public void separateItem() 
    {
        if (this.canSeparate()) {
            ArrayList<ItemStack> itemstack = SeparatorRecipes.getInstance().getSeparatorResult(this.itemStacks[FIRST_INPUT_SLOT], this.itemStacks[FIRST_INPUT_SLOT + 1]);
            
            if (this.itemStacks[FIRST_OUTPUT_SLOT] == null) {
                itemStacks[FIRST_OUTPUT_SLOT] = itemstack.get(MAX_CAPACITY).copy();
            }
            else if (this.itemStacks[FIRST_OUTPUT_SLOT].getItem() == itemstack.get(0).getItem() && this.itemStacks[FIRST_OUTPUT_SLOT].stackSize + itemstack.get(0).stackSize <= this.MAX_CAPACITY) {
                this.itemStacks[FIRST_OUTPUT_SLOT].stackSize += itemstack.get(0).stackSize;
            }
            
            if (this.itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                itemStacks[FIRST_OUTPUT_SLOT + 1] = itemstack.get(MAX_CAPACITY).copy();
            }
            else if (this.itemStacks[FIRST_OUTPUT_SLOT + 1].getItem() == itemstack.get(1).getItem() && this.itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + itemstack.get(1).stackSize <= this.MAX_CAPACITY) {
                this.itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += itemstack.get(1).stackSize;
            }
            
            if (this.itemStacks[FIRST_OUTPUT_SLOT + 2] == null) {
                itemStacks[FIRST_OUTPUT_SLOT + 2] = itemstack.get(MAX_CAPACITY).copy();
            }
            else if (this.itemStacks[FIRST_OUTPUT_SLOT + 2].getItem() == itemstack.get(2).getItem() && this.itemStacks[FIRST_OUTPUT_SLOT + 2].stackSize + itemstack.get(2).stackSize <= this.MAX_CAPACITY) {
                this.itemStacks[FIRST_OUTPUT_SLOT + 2].stackSize += itemstack.get(2).stackSize;
            }

            itemStacks[FIRST_INPUT_SLOT].stackSize--;
            itemStacks[FIRST_INPUT_SLOT + SeparatorRecipes.getInstance().getNumBottles(itemStacks[FIRST_INPUT_SLOT])].stackSize--;
            
            if (this.itemStacks[FIRST_INPUT_SLOT].stackSize <= 0) {
                this.itemStacks[FIRST_INPUT_SLOT] = null;
            } else if (this.itemStacks[FIRST_INPUT_SLOT + 1].stackSize <= 0) {
                this.itemStacks[FIRST_INPUT_SLOT + 1] = null;
            }
        }
    }
    
    @Override
    public boolean isBurning()
    {
        return cookTime > 0;
    }
    
    @Override
    public String getName()
    {
        return "         Chemical Separator";
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
        return new ContainerChemicalSeparator(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return "industrialmetallurgy:chemical_separator";
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