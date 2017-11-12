package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemInvarIngot extends Item 
{
	public ItemInvarIngot()
	{
		setUnlocalizedName(Reference.TestModItems.INVAR_INGOT.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.INVAR_INGOT.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
