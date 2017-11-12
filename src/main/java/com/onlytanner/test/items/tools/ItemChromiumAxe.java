package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemChromiumAxe extends ItemAxe
{
	public ItemChromiumAxe() 
	{
		super(ModItems.CHROMIUM, ModItems.CHROMIUM.getDamageVsEntity(), ModItems.CHROMIUM.getEfficiencyOnProperMaterial());
		setUnlocalizedName(Reference.TestModItems.CHROMIUM_AXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CHROMIUM_AXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
