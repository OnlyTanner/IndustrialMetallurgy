package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemInvarNugget extends Item 
{
	public ItemInvarNugget()
	{
		setUnlocalizedName(Reference.TestModItems.INVAR_NUGGET.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.INVAR_NUGGET.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
