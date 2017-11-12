package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemInvarPickaxe extends ItemPickaxe 
{
	public ItemInvarPickaxe() 
	{
		super(ModItems.INVAR);
		setUnlocalizedName(Reference.TestModItems.INVAR_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.INVAR_PICKAXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
