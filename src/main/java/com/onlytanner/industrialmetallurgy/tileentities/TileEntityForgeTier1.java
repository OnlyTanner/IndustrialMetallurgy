package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.blocks.BlockForgeTier1;
import com.onlytanner.industrialmetallurgy.container.ContainerForgeTier1;
import com.onlytanner.industrialmetallurgy.items.crafting.ForgeRecipes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;

public class TileEntityForgeTier1 extends TileEntityBase
{
    private int cachedNumberOfBurningSlots = -1;

    public TileEntityForgeTier1()
    {
        super(2, 2, 1);
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
            BlockForgeTier1.setState(this.isBurning(), this.worldObj, this.pos);
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
     * checks that there is an item to be smelted in one of the input slots and
     * that there is room for the result in the output slots If desired,
     * performs the smelt
     *
     * @param performSmelt if true, perform the smelt. if false, check whether
     * smelting is possible, but don't change the inventory
     * @return false if no items can be smelted, true otherwise
     */
    private boolean smeltItem(boolean performSmelt)
    {
        if (((itemStacks[FIRST_INPUT_SLOT] != null && itemStacks[FIRST_INPUT_SLOT + 1] != null) && itemStacks[FIRST_INPUT_SLOT].isItemEqual(itemStacks[FIRST_INPUT_SLOT + 1]))) {
            return getResult(0, 2, performSmelt);
        } else if (itemStacks[FIRST_INPUT_SLOT] != null && itemStacks[FIRST_INPUT_SLOT + 1] == null) {
            return getResult(0, 1, performSmelt);
        } else if (itemStacks[FIRST_INPUT_SLOT] == null && itemStacks[FIRST_INPUT_SLOT + 1] != null) {
            return getResult(1, 1, performSmelt);
        } else if (itemStacks[FIRST_INPUT_SLOT] != null && itemStacks[FIRST_INPUT_SLOT + 1] != null) {
            return getResult(performSmelt);
        } else {
            return false;
        }
    }

    private boolean getResult(int index, int numOfOutputs, boolean performSmelt)
    {
        ItemStack result = getSmeltingResultForItem(itemStacks[FIRST_INPUT_SLOT + index], numOfOutputs);

        if ((itemStacks[FIRST_INPUT_SLOT] == null && itemStacks[FIRST_INPUT_SLOT + 1] == null) || result == null) {
            return false;
        }
        if (!performSmelt
                && (itemStacks[FIRST_OUTPUT_SLOT] == null || itemStacks[FIRST_OUTPUT_SLOT + 1] == null
                || (itemStacks[FIRST_OUTPUT_SLOT] != null && itemStacks[FIRST_OUTPUT_SLOT].isItemEqual(result))
                || (itemStacks[FIRST_OUTPUT_SLOT + 1] != null && itemStacks[FIRST_OUTPUT_SLOT + 1].isItemEqual(result)))) {
            return true;
        }

        // alter input and output
        if (numOfOutputs == 1) {
            if (itemStacks[FIRST_INPUT_SLOT + index].stackSize <= 1) {
                itemStacks[FIRST_INPUT_SLOT + index] = null;
            } else {
                itemStacks[FIRST_INPUT_SLOT + index].stackSize--;
            }
        } else if (itemStacks[FIRST_INPUT_SLOT + index].stackSize <= 1 && itemStacks[FIRST_INPUT_SLOT + index + 1].stackSize <= 1) {
            itemStacks[FIRST_INPUT_SLOT + index] = null;
            itemStacks[FIRST_INPUT_SLOT + index + 1] = null;
        } else if (itemStacks[FIRST_INPUT_SLOT + index].stackSize <= 1 && itemStacks[FIRST_INPUT_SLOT + index + 1].stackSize > 1) {
            itemStacks[FIRST_INPUT_SLOT + index] = null;
            itemStacks[FIRST_INPUT_SLOT + index + 1].stackSize--;
        } else if (itemStacks[FIRST_INPUT_SLOT + index].stackSize > 1 && itemStacks[FIRST_INPUT_SLOT + index + 1].stackSize <= 1) {
            itemStacks[FIRST_INPUT_SLOT + index].stackSize--;
            itemStacks[FIRST_INPUT_SLOT + index + 1] = null;
        } else {
            itemStacks[FIRST_INPUT_SLOT + index].stackSize--;
            itemStacks[FIRST_INPUT_SLOT + index + 1].stackSize--;
        }

        if (itemStacks[FIRST_OUTPUT_SLOT] == null) {
            itemStacks[FIRST_OUTPUT_SLOT] = result.copy(); // Use deep .copy() to avoid altering the recipe
        } else if (itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.stackSize <= this.getInventoryStackLimit()) {
            if (itemStacks[FIRST_OUTPUT_SLOT].getItem() == result.getItem()) {
                itemStacks[FIRST_OUTPUT_SLOT].stackSize += result.stackSize;
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                itemStacks[FIRST_OUTPUT_SLOT + 1] = result.copy();
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.stackSize <= this.getInventoryStackLimit() && result.getItem() == itemStacks[FIRST_OUTPUT_SLOT + 1].getItem()) {
                itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += result.stackSize;
            } else {
                return false;
            }
        } else if (itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.stackSize > this.getInventoryStackLimit() && itemStacks[FIRST_OUTPUT_SLOT].stackSize < this.getInventoryStackLimit()) {
            if (itemStacks[FIRST_OUTPUT_SLOT].getItem() == result.getItem()) {
                int temp = itemStacks[FIRST_OUTPUT_SLOT].stackSize;
                itemStacks[FIRST_OUTPUT_SLOT].stackSize = this.getInventoryStackLimit();
                if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1] = new ItemStack(result.getItem(), result.stackSize - (this.getInventoryStackLimit() - temp));
                } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].getItem() == result.getItem()) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += this.getInventoryStackLimit() - temp;
                } else {
                    return false;
                }
            } else {
                if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1] = result.copy();
                } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.stackSize <= this.getInventoryStackLimit() && result.getItem() == itemStacks[FIRST_OUTPUT_SLOT + 1].getItem()) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += result.stackSize;
                } else {
                    return false;
                }
            }
        } else if (itemStacks[FIRST_OUTPUT_SLOT].stackSize == this.getInventoryStackLimit()) {
            if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                itemStacks[FIRST_OUTPUT_SLOT + 1] = result.copy();
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].getItem() == result.getItem() && itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.stackSize <= this.getInventoryStackLimit()) {
                itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += result.stackSize;
            } else {
                return false;
            }
        } else {
            return false;
        }

        markDirty();
        return true;
    }

    private boolean getResult(boolean performSmelt)
    {
        ItemStack result = getAlloyResultForItem(itemStacks[FIRST_INPUT_SLOT], itemStacks[FIRST_INPUT_SLOT + 1]);

        if ((itemStacks[FIRST_INPUT_SLOT] == null || itemStacks[FIRST_INPUT_SLOT + 1] == null) || result == null) {
            return false;
        }
        if (!performSmelt
                && (itemStacks[FIRST_OUTPUT_SLOT] == null || itemStacks[FIRST_OUTPUT_SLOT + 1] == null
                || (itemStacks[FIRST_OUTPUT_SLOT] != null && itemStacks[FIRST_OUTPUT_SLOT].isItemEqual(result))
                || (itemStacks[FIRST_OUTPUT_SLOT + 1] != null && itemStacks[FIRST_OUTPUT_SLOT + 1].isItemEqual(result)))) {
            return true;
        }

        // alter input and output
        ItemStack[] stack = ForgeRecipes.getReducedStacks(itemStacks[FIRST_INPUT_SLOT], itemStacks[FIRST_INPUT_SLOT + 1]);
        if (itemStacks[FIRST_INPUT_SLOT].stackSize <= stack[0].stackSize) {
            if (itemStacks[FIRST_INPUT_SLOT + 1].stackSize <= stack[1].stackSize) {
                itemStacks[FIRST_INPUT_SLOT] = null;
                itemStacks[FIRST_INPUT_SLOT + 1] = null;
            } else {
                itemStacks[FIRST_INPUT_SLOT] = null;
                itemStacks[FIRST_INPUT_SLOT + 1] = new ItemStack(itemStacks[FIRST_INPUT_SLOT + 1].getItem(), itemStacks[FIRST_INPUT_SLOT + 1].stackSize - stack[1].stackSize);
            }
        } else if (itemStacks[FIRST_INPUT_SLOT + 1].stackSize <= stack[1].stackSize) {
            itemStacks[FIRST_INPUT_SLOT] = new ItemStack(itemStacks[FIRST_INPUT_SLOT].getItem(), itemStacks[FIRST_INPUT_SLOT].stackSize - stack[0].stackSize);
            itemStacks[FIRST_INPUT_SLOT + 1] = null;
        } else {
            itemStacks[FIRST_INPUT_SLOT] = new ItemStack(itemStacks[FIRST_INPUT_SLOT].getItem(), itemStacks[FIRST_INPUT_SLOT].stackSize - stack[0].stackSize);
            itemStacks[FIRST_INPUT_SLOT + 1] = new ItemStack(itemStacks[FIRST_INPUT_SLOT + 1].getItem(), itemStacks[FIRST_INPUT_SLOT + 1].stackSize - stack[1].stackSize);
        }

        if (itemStacks[FIRST_OUTPUT_SLOT] == null) {
            itemStacks[FIRST_OUTPUT_SLOT] = result.copy(); // Use deep .copy() to avoid altering the recipe
        } else if (itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.stackSize <= this.getInventoryStackLimit()) {
            if (itemStacks[FIRST_OUTPUT_SLOT].getItem() == result.getItem()) {
                itemStacks[FIRST_OUTPUT_SLOT].stackSize += result.stackSize;
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                itemStacks[FIRST_OUTPUT_SLOT + 1] = result.copy();
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.stackSize <= this.getInventoryStackLimit() && result.getItem() == itemStacks[FIRST_OUTPUT_SLOT + 1].getItem()) {
                itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += result.stackSize;
            } else {
                return false;
            }
        } else if (itemStacks[FIRST_OUTPUT_SLOT].stackSize + result.stackSize > this.getInventoryStackLimit() && itemStacks[FIRST_OUTPUT_SLOT].stackSize < this.getInventoryStackLimit()) {
            if (itemStacks[FIRST_OUTPUT_SLOT].getItem() == result.getItem()) {
                int temp = itemStacks[FIRST_OUTPUT_SLOT].stackSize;
                itemStacks[FIRST_OUTPUT_SLOT].stackSize = this.getInventoryStackLimit();
                if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1] = new ItemStack(result.getItem(), result.stackSize - (this.getInventoryStackLimit() - temp));
                } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].getItem() == result.getItem()) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += this.getInventoryStackLimit() - temp;
                } else {
                    return false;
                }
            } else {
                if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1] = result.copy();
                } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.stackSize <= this.getInventoryStackLimit() && result.getItem() == itemStacks[FIRST_OUTPUT_SLOT + 1].getItem()) {
                    itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += result.stackSize;
                } else {
                    return false;
                }
            }
        } else if (itemStacks[FIRST_OUTPUT_SLOT].stackSize == this.getInventoryStackLimit()) {
            if (itemStacks[FIRST_OUTPUT_SLOT + 1] == null) {
                itemStacks[FIRST_OUTPUT_SLOT + 1] = result.copy();
            } else if (itemStacks[FIRST_OUTPUT_SLOT + 1].getItem() == result.getItem() && itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize + result.stackSize <= this.getInventoryStackLimit()) {
                itemStacks[FIRST_OUTPUT_SLOT + 1].stackSize += result.stackSize;
            } else {
                return false;
            }
        } else {
            return false;
        }

        markDirty();
        return false;
    }

    public int getTemperatureOfCurrent()
    {
        if (itemStacks[FIRST_INPUT_SLOT] != null && itemStacks[FIRST_INPUT_SLOT + 1] != null) {
            try {
                return ForgeRecipes.getTemperature(ForgeRecipes.getAlloyResult(itemStacks[FIRST_INPUT_SLOT], itemStacks[FIRST_INPUT_SLOT + 1]).getItem());
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
        return "            Forge (Tier 1)";
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
        return new ContainerForgeTier1(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return "industrialmetallurgy:forge_tier1";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }
}
