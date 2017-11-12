package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemBronzeAxe extends ItemAxe
{
	public ItemBronzeAxe() 
	{
		super(ModItems.BRONZE, ModItems.BRONZE.getDamageVsEntity(), ModItems.BRONZE.getEfficiencyOnProperMaterial());
		setUnlocalizedName(Reference.TestModItems.BRONZE_AXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.BRONZE_AXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
