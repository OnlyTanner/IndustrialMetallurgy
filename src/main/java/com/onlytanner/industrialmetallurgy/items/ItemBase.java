package com.onlytanner.industrialmetallurgy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemBase extends Item
{
    public ItemBase(String unlocalizedName, String registryName, CreativeTabs tab)
    {
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}
