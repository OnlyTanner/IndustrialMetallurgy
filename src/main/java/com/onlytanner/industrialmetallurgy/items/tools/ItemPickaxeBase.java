package com.onlytanner.industrialmetallurgy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemPickaxeBase extends ItemPickaxe
{
    public ItemPickaxeBase(String unlocalizedName, String registryName, CreativeTabs tab, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}
