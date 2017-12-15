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

public class TileEntityElectricCrusher extends TileEntityBase
{
    private int cachedNumberOfBurningSlots = -1;
    
    public TileEntityElectricCrusher()
    {
        super(2, 1, 0, 100);
    }

    @Override
    public void update()
    {
       
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
        return "            Electric Crusher";
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
        return new ContainerCrusher(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return "industrialmetallurgy:electric_crusher";
    }
}