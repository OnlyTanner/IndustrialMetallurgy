package com.onlytanner.test;

import com.onlytanner.test.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestModToolsTab extends CreativeTabs {

    public TestModToolsTab() {
        super("tabTestModTools");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.copper_pickaxe;
    }
}
