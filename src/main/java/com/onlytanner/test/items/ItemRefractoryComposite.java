package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemRefractoryComposite extends Item
{
	public ItemRefractoryComposite() 
	{
		setUnlocalizedName(Reference.TestModItems.REFRACTORY_COMPOSITE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.REFRACTORY_COMPOSITE.getRegistryName());
		setCreativeTab(TestMod.SMELTING_TAB);
	}

}
