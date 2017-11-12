package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemTitaniumHoe extends ItemHoe
{
	public ItemTitaniumHoe() 
	{
		super(ModItems.TITANIUM);
		setUnlocalizedName(Reference.TestModItems.TITANIUM_HOE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.TITANIUM_HOE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}