package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemNickelHoe extends ItemHoe
{
	public ItemNickelHoe() 
	{
		super(ModItems.NICKEL);
		setUnlocalizedName(Reference.TestModItems.NICKEL_HOE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICKEL_HOE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}