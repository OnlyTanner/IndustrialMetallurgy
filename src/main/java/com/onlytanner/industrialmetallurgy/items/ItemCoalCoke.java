package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class ItemCoalCoke extends Item implements IFuelHandler 
{
    public ItemCoalCoke() 
    {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COAL_COKE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COAL_COKE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }

    @Override
    public int getBurnTime(ItemStack is)
    {
        if (is.getItem().equals(this))
            return 3200;
        return 0;
    }
}
