package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemAluminumNugget extends Item 
{
	public ItemAluminumNugget()
	{
		setUnlocalizedName(Reference.TestModItems.ALUMINUM_NUGGET.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ALUMINUM_NUGGET.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
