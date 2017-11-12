package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemNitinolPickaxe extends ItemPickaxe
{
	public ItemNitinolPickaxe() 
	{
		super(ModItems.NITINOL);
		setUnlocalizedName(Reference.TestModItems.NITINOL_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NITINOL_PICKAXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
