package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.blocks.BlockForgeTier2;
import com.onlytanner.industrialmetallurgy.container.ContainerForgeTier2;
import com.onlytanner.industrialmetallurgy.items.crafting.ForgeRecipes;
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
import net.minecraft.util.ITickable;
import net.minecraft.world.EnumSkyBlock;

public class TileEntityForgeTier2 extends TileEntityBase implements ITickable
{
    public enum Mode {
        ALLOY((byte)0), SMELT((byte)1);
        
        byte value;
        Mode(byte value)
        {
            this.value = value;
        }
    };
    private int cachedNumberOfBurningSlots = -1;
    private static Mode mode;
    private ArrayList<ItemStack> inputs;

    public TileEntityForgeTier2()
    {
        super(3, 1, 1, 50);
        mode = Mode.ALLOY;
        inputs = new ArrayList<ItemStack>();
        inputs.add(itemStacks[FIRST_INPUT_SLOT]);
        inputs.add(itemStacks[FIRST_INPUT_SLOT + 1]);
        inputs.add(itemStacks[FIRST_INPUT_SLOT + 2]);
    }

    @Override
    public void update()
    {
        // If there is nothing to smelt or there is no room in the output, reset cookTime and return
        boolean flag = this.isBurning();
        boolean flag1 = false;
        
        if (smeltItem(false)) {
            int numberOfFuelBurning = burnFuel();
            // If fuel is available, keep cooking the item, otherwise start "uncooking" it at double speed
            if (numberOfFuelBurning > 0) {
                cookTime += numberOfFuelBurning;
            } else {
                cookTime -= 2;
            }

            if (cookTime < 0) {
                cookTime = 0;
            }

            // If cookTime has reached maxCookTime smelt the item and reset cookTime
            if (cookTime >= COOK_TIME_FOR_COMPLETION) {
                smeltItem(true);
                cookTime = 0;
            }
        } else if (burnTimeRemaining[0] > 1) {
            cookTime = 0;
            burnFuel();
        } else {
            cookTime = 0;
        }

        if (flag != this.isBurning()) {
            flag1 = true;
            BlockForgeTier2.setState(this.isBurning(), this.worldObj, this.pos);
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
    
    public boolean smeltItem(boolean performSmelt)
    {
        inputs.set(0, itemStacks[FIRST_INPUT_SLOT]);
        inputs.set(1, itemStacks[FIRST_INPUT_SLOT + 1]);
        inputs.set(2, itemStacks[FIRST_INPUT_SLOT + 2]);
        if (mode == Mode.ALLOY)
        {
            //check for valid recipe based on inputs
            ItemStack result = ForgeRecipes.getAlloyResult(inputs);
            
            //if recipe was valid, alter inputs and outputs appropriately
            if (result != null)
            {
                ItemStack[] stacks = ForgeRecipes.getReducedStacks(itemStacks[FIRST_INPUT_SLOT], itemStacks[FIRST_INPUT_SLOT + 1], itemStacks[FIRST_INPUT_SLOT + 2]);
                if (itemStacks[FIRST_OUTPUT_SLOT] != null && 
                    itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.stackSize <= this.getInventoryStackLimit() && 
                    itemStacks[FIRST_OUTPUT_SLOT].getItem().equals(result.getItem()))
                    if (!performSmelt)
                        return true;
                    else
                    {
                        itemStacks[FIRST_OUTPUT_SLOT].stackSize += result.stackSize;
                        itemStacks[FIRST_INPUT_SLOT].stackSize -= stacks[0].stackSize;
                        itemStacks[FIRST_INPUT_SLOT + 1].stackSize -= stacks[1].stackSize;
                        itemStacks[FIRST_INPUT_SLOT + 2].stackSize -= stacks[2].stackSize;
                        if (itemStacks[FIRST_INPUT_SLOT].stackSize <= 0)
                            itemStacks[FIRST_INPUT_SLOT] = null;
                        if (itemStacks[FIRST_INPUT_SLOT + 1].stackSize <= 0)
                            itemStacks[FIRST_INPUT_SLOT + 1] = null;
                        if (itemStacks[FIRST_INPUT_SLOT + 2].stackSize <= 0)
                            itemStacks[FIRST_INPUT_SLOT + 2] = null;
                    }
                else if (itemStacks[FIRST_OUTPUT_SLOT] == null)
                    if (!performSmelt)
                        return true;
                    else
                    {
                        itemStacks[FIRST_OUTPUT_SLOT] = result.copy();
                        itemStacks[FIRST_INPUT_SLOT].stackSize -= stacks[0].stackSize;
                        itemStacks[FIRST_INPUT_SLOT + 1].stackSize -= stacks[1].stackSize;
                        itemStacks[FIRST_INPUT_SLOT + 2].stackSize -= stacks[2].stackSize;
                        if (itemStacks[FIRST_INPUT_SLOT].stackSize <= 0)
                            itemStacks[FIRST_INPUT_SLOT] = null;
                        if (itemStacks[FIRST_INPUT_SLOT + 1].stackSize <= 0)
                            itemStacks[FIRST_INPUT_SLOT + 1] = null;
                        if (itemStacks[FIRST_INPUT_SLOT + 2].stackSize <= 0)
                            itemStacks[FIRST_INPUT_SLOT + 2] = null;
                    }
                else
                    return false;
            }
            else
                return false;
        }
        else 
        {
            //check for valid recipe based on inputs
            ItemStack result = null;
            if (inputs.get(0) != null)
                result = getSmeltingResultForItem(inputs.get(0), 1);
            else if (inputs.get(1) != null)
                result = getSmeltingResultForItem(inputs.get(1), 1);
            else if (inputs.get(2) != null)
                result = getSmeltingResultForItem(inputs.get(2), 1);
            
            //if recipe was valid, alter inputs and outputs appropriately
            if (result != null)
                if (itemStacks[FIRST_OUTPUT_SLOT] != null && 
                    itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.stackSize <= this.getInventoryStackLimit() && 
                    itemStacks[FIRST_OUTPUT_SLOT].getItem().equals(result.getItem()))
                    if (!performSmelt)
                        return true;
                    else
                    {
                        itemStacks[FIRST_OUTPUT_SLOT].stackSize += result.stackSize;
                        if (itemStacks[FIRST_INPUT_SLOT] != null)
                            itemStacks[FIRST_INPUT_SLOT].stackSize--;
                        else if (itemStacks[FIRST_INPUT_SLOT + 1] != null)
                            itemStacks[FIRST_INPUT_SLOT + 1].stackSize--;
                        else if (itemStacks[FIRST_INPUT_SLOT + 2] != null)
                            itemStacks[FIRST_INPUT_SLOT + 2].stackSize--;
                    }
                else if (itemStacks[FIRST_OUTPUT_SLOT] == null)
                    if (!performSmelt)
                        return true;
                    else
                    {
                        itemStacks[FIRST_OUTPUT_SLOT] = result.copy();
                        if (itemStacks[FIRST_INPUT_SLOT] != null)
                            itemStacks[FIRST_INPUT_SLOT].stackSize--;
                        else if (itemStacks[FIRST_INPUT_SLOT + 1] != null)
                            itemStacks[FIRST_INPUT_SLOT + 1].stackSize--;
                        else if (itemStacks[FIRST_INPUT_SLOT + 2] != null)
                            itemStacks[FIRST_INPUT_SLOT + 2].stackSize--;
                    }
                else
                    return false;
            else
                return false;
        }
        
        markDirty();
        return true;
    }

    /**
     * for each fuel slot: decreases the burn time, checks if burnTimeRemaining
     * = 0 and tries to consume a new piece of fuel if one is available
     *
     * @return the number of fuel slots which are burning
     */
    private int burnFuel()
    {
        int burningCount = 0;
        boolean inventoryChanged = false;
        // Iterate over all the fuel slots
        for (int i = 0; i < FUEL_SLOTS_COUNT; i++) {
            int fuelSlotNumber = i + FIRST_FUEL_SLOT;
            if (burnTimeRemaining[i] > 0) {
                --burnTimeRemaining[i];
                ++burningCount;
            }
            if (burnTimeRemaining[i] == 0) {
                if (itemStacks[fuelSlotNumber] != null && getItemBurnTime(itemStacks[fuelSlotNumber]) > 0) {
                    // If the stack in this slot is not null and is fuel, set burnTimeRemaining & burnTimeInitialValue to the
                    // item's burn time and decrease the stack size
                    burnTimeRemaining[i] = burnTimeInitialValue[i] = getItemBurnTime(itemStacks[fuelSlotNumber]);
                    --itemStacks[fuelSlotNumber].stackSize;
                    ++burningCount;
                    inventoryChanged = true;
                    // If the stack size now equals 0 set the slot contents to the items container item. This is for fuel
                    // items such as lava buckets so that the bucket is not consumed. If the item dose not have
                    // a container item getContainerItem returns null which sets the slot contents to null
                    if (itemStacks[fuelSlotNumber].stackSize == 0) {
                        itemStacks[fuelSlotNumber] = itemStacks[fuelSlotNumber].getItem().getContainerItem(itemStacks[fuelSlotNumber]);
                    }
                }
            }
        }
        if (inventoryChanged) {
            markDirty();
        }
        return burningCount;
    }

    public int getTemperatureOfCurrent()
    {
        if (itemStacks[FIRST_INPUT_SLOT] != null && itemStacks[FIRST_INPUT_SLOT + 1] != null) {
            try {
                inputs.set(0, itemStacks[FIRST_INPUT_SLOT]);
                inputs.set(1, itemStacks[FIRST_INPUT_SLOT + 1]);
                inputs.set(2, itemStacks[FIRST_INPUT_SLOT + 2]);
                return ForgeRecipes.getTemperature(ForgeRecipes.getAlloyResult(inputs).getItem());
            } catch (NullPointerException e) {
                return 500;
            }
        } else {
            return 500;
        }
    }

    @Override
    public String getName()
    {
        return "            Forge (Tier 2)";
    }

    @Override
    public int getField(int id)
    {
        switch (id) {
            case 0:
                return this.burnTimeInitialValue[0];
            case 1:
                return this.burnTimeRemaining[0];
            case 2:
                return this.cookTime;
            case 3:
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
                this.burnTimeInitialValue[0] = value;
                break;
            case 1:
                this.burnTimeRemaining[0] = value;
                break;
            case 2:
                this.cookTime = (short) value;
                break;
            case 3:
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
        parentNBTTagCompound.setByte("Mode", mode.value);

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
        
        mode.value = nbtTagCompound.getByte("Mode");

        // Load everything else.  Trim the arrays (or pad with 0) to make sure they have the correct number of elements
        cookTime = nbtTagCompound.getShort("CookTime");
        burnTimeRemaining = Arrays.copyOf(nbtTagCompound.getIntArray("burnTimeRemaining"), FUEL_SLOTS_COUNT);
        burnTimeInitialValue = Arrays.copyOf(nbtTagCompound.getIntArray("burnTimeInitial"), FUEL_SLOTS_COUNT);
    }
    
    public Mode getMode()
    {
        return mode;
    }
    
    public void setMode(Mode mode)
    {
        if (mode == null)
            mode = Mode.ALLOY;
        if (this.mode != mode)
        {
            this.mode = mode;
            this.markDirty();
        }
    }

    @Override
    public int getFieldCount()
    {
        return 4;
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
        return new ContainerForgeTier2(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return "industrialmetallurgy:forge_tier2";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }
}