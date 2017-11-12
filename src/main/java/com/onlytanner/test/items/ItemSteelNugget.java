package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemSteelNugget extends Item 
{
	public ItemSteelNugget()
	{
		setUnlocalizedName(Reference.TestModItems.STEEL_NUGGET.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.STEEL_NUGGET.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
