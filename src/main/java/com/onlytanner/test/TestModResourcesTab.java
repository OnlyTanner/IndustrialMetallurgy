package com.onlytanner.test;

import com.onlytanner.test.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestModResourcesTab extends CreativeTabs
{
	public TestModResourcesTab() {
		super("tabTestModResources");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.copper_ingot;
	}
}
