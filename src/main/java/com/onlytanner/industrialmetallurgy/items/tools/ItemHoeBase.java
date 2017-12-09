package com.onlytanner.industrialmetallurgy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemHoeBase extends ItemHoe
{
    public ItemHoeBase(String unlocalizedName, String registryName, CreativeTabs tab, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}
