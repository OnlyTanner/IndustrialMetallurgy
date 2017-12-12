package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemCoalCokeFuel extends Item implements IFuelHandler
{
    public ItemCoalCokeFuel()
    {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COAL_COKE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COAL_COKE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
    
    @Override
    public int getBurnTime(ItemStack is)
    {
        if(is.getItem().equals(ModItems.coal_coke))
            return 3200;
        else
            return 0;
    }
}
