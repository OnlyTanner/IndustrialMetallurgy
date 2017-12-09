package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.blocks.BlockCrusher;
import com.onlytanner.industrialmetallurgy.container.ContainerCrusher;
import com.onlytanner.industrialmetallurgy.items.crafting.CrusherRecipes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;

public class TileEntityCrusher extends TileEntityBase
{
    private int cachedNumberOfBurningSlots = -1;
    
    public TileEntityCrusher()
    {
        super(1, 2, 1);
    }

    @Override
    public void update()
    {
        // If there is nothing to smelt or there is no room in the output, reset cookTime and return
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (canCrush()) {
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
                crushItem();
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
            BlockCrusher.setState(this.isBurning(), this.worldObj, this.pos);
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
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item,
     * destination stack isn't full, etc.
     */
    private boolean canCrush() 
    {
        if (this.itemStacks[FIRST_INPUT_SLOT] == null) {
            return false;
        } else {
            ItemStack itemstack = CrusherRecipes.instance().getCrushingResult(this.itemStacks[FIRST_INPUT_SLOT]);
            if (itemstack == null) {
                return false;
            }
            if (this.itemStacks[FIRST_OUTPUT_SLOT] == null || this.itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                return true;
            }
            if (!this.itemStacks[FIRST_OUTPUT_SLOT].isItemEqual(itemstack) && !this.itemStacks[FIRST_OUTPUT_SLOT + 1].isItemEqual(itemstack)) {
                return false;
            }
            
            int result;
            if (itemStacks[FIRST_OUTPUT_SLOT].stackSize != this.getInventoryStackLimit()) {
                result = itemStacks[FIRST_OUTPUT_SLOT].stackSize + itemstack.stackSize;
            } else {
                result = itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + itemstack.stackSize;
            }
            return result <= getInventoryStackLimit() && result <= this.itemStacks[FIRST_OUTPUT_SLOT].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted
     * item in the furnace result stack
     */
    public void crushItem() 
    {
        if (this.canCrush()) {
            ItemStack itemstack = CrusherRecipes.instance().getCrushingResult(this.itemStacks[FIRST_INPUT_SLOT]);

            if (this.itemStacks[FIRST_OUTPUT_SLOT] == null) {
                this.itemStacks[FIRST_OUTPUT_SLOT] = itemstack.copy();
            } else if (this.itemStacks[FIRST_OUTPUT_SLOT].getItem() == itemstack.getItem()) {
                this.itemStacks[FIRST_OUTPUT_SLOT].stackSize += itemstack.stackSize;
            } else if (this.itemStacks[FIRST_OUTPUT_SLOT + 1].getItem() == itemstack.getItem()) {
                this.itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += itemstack.stackSize;
            }

            --this.itemStacks[FIRST_INPUT_SLOT].stackSize;

            if (this.itemStacks[FIRST_INPUT_SLOT].stackSize <= 0) {
                this.itemStacks[FIRST_INPUT_SLOT] = null;
            }
        }
    }

    // returns the smelting result for the given stack. Returns null if the given stack can not be smelted
    public static ItemStack getCrushingResultForItem(ItemStack stack) 
    {
        return CrusherRecipes.instance().getCrushingResult(stack);
    }

    @Override
    public String getName()
    {
        return "                Crusher";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
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
        return new ContainerCrusher(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return "industrialmetallurgy:crusher";
    }
}