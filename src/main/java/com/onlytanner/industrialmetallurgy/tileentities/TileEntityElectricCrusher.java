package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.blocks.BlockElectricCrusher;
import com.onlytanner.industrialmetallurgy.container.ContainerCrusher;
import com.onlytanner.industrialmetallurgy.items.crafting.CrusherRecipes;
import net.minecraft.block.state.IBlockState;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.EnumSkyBlock;

public class TileEntityElectricCrusher extends TileEntityBase implements ITickable, IEnergyReceiver
{
    private int cachedNumberOfBurningSlots = -1;
    public final int MAX_CAPACITY = 100000;
    public ModEnergyStorage storage = new ModEnergyStorage(MAX_CAPACITY, 0, 80);
    
    public TileEntityElectricCrusher()
    {
        super(1, 2, 0, 100);
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

        if (canCrush()) {
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
                crushItem();
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
    
    @Override
    public boolean isBurning()
    {
        return cookTime > 0;
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