package com.onlytanner.test;

import com.onlytanner.test.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestModSmeltingTab extends CreativeTabs
{
	public TestModSmeltingTab() {
		super("tabTestModSmelting");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.forge_tier1);
	}
}
