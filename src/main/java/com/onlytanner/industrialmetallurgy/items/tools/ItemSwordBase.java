package com.onlytanner.industrialmetallurgy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemSwordBase extends ItemSword
{
    public ItemSwordBase(String unlocalizedName, String registryName, CreativeTabs tab, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}
