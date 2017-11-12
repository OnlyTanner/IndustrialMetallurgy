package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemBrassNugget extends Item 
{
	public ItemBrassNugget()
	{
		setUnlocalizedName(Reference.TestModItems.BRASS_NUGGET.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.BRASS_NUGGET.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
