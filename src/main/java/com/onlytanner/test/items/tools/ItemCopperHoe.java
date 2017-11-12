package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemCopperHoe extends ItemHoe
{
	public ItemCopperHoe() 
	{
		super(ModItems.COPPER);
		setUnlocalizedName(Reference.TestModItems.COPPER_HOE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.COPPER_HOE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}