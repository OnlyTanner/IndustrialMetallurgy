package com.onlytanner.industrialmetallurgy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemShovelBase extends ItemSpade
{
    public ItemShovelBase(String unlocalizedName, String registryName, CreativeTabs tab, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}
