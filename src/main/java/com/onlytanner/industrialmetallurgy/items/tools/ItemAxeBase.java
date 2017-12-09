package com.onlytanner.industrialmetallurgy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

/**
 *
 * @author Tanner Lisonbee
 */
public class ItemAxeBase extends ItemAxe
{
    public ItemAxeBase(String unlocalizedName, String registryName, CreativeTabs tab, ToolMaterial material)
    {
        super(material, material.getDamageVsEntity(), material.getEfficiencyOnProperMaterial());
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}
