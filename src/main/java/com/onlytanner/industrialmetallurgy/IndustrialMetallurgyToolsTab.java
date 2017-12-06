package com.onlytanner.industrialmetallurgy;

import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IndustrialMetallurgyToolsTab extends CreativeTabs {

    public IndustrialMetallurgyToolsTab() {
        super("tabIndustrialMetallurgyTools");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.copper_pickaxe;
    }
}
