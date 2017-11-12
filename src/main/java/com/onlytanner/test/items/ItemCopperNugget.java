package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCopperNugget extends Item 
{
	public ItemCopperNugget()
	{
		setUnlocalizedName(Reference.TestModItems.COPPER_NUGGET.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.COPPER_NUGGET.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
