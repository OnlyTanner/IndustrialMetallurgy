package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemNitinolAxe extends ItemAxe
{
	public ItemNitinolAxe() 
	{
		super(ModItems.NITINOL, ModItems.NITINOL.getDamageVsEntity(), ModItems.NITINOL.getEfficiencyOnProperMaterial());
		setUnlocalizedName(Reference.TestModItems.NITINOL_AXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NITINOL_AXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}