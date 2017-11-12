package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemTinAxe extends ItemAxe
{
	public ItemTinAxe() 
	{
		super(ModItems.TIN, ModItems.TIN.getDamageVsEntity(), ModItems.TIN.getEfficiencyOnProperMaterial());
		setUnlocalizedName(Reference.TestModItems.TIN_AXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.TIN_AXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
