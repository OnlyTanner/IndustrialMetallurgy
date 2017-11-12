package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemBrassAxe extends ItemAxe
{
	public ItemBrassAxe() 
	{
		super(ModItems.BRASS, ModItems.BRASS.getDamageVsEntity(), ModItems.BRASS.getEfficiencyOnProperMaterial());
		setUnlocalizedName(Reference.TestModItems.BRASS_AXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.BRASS_AXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
