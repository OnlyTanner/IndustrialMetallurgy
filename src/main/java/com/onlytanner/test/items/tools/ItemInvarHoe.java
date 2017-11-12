package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemInvarHoe extends ItemHoe
{
	public ItemInvarHoe() 
	{
		super(ModItems.INVAR);
		setUnlocalizedName(Reference.TestModItems.INVAR_HOE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.INVAR_HOE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}