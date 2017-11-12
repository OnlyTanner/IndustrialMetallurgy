package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemAluminumHoe extends ItemHoe
{
	public ItemAluminumHoe() 
	{
		super(ModItems.ALUMINUM);
		setUnlocalizedName(Reference.TestModItems.ALUMINUM_HOE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ALUMINUM_HOE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
