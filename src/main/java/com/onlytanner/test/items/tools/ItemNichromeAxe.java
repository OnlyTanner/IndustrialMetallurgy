package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemNichromeAxe extends ItemAxe
{
	public ItemNichromeAxe() 
	{
		super(ModItems.NICHROME, ModItems.NICHROME.getDamageVsEntity(), ModItems.NICHROME.getEfficiencyOnProperMaterial());
		setUnlocalizedName(Reference.TestModItems.NICHROME_AXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICHROME_AXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}