package com.onlytanner.industrialmetallurgy;

import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IndustrialMetallurgyResourcesTab extends CreativeTabs {

    public IndustrialMetallurgyResourcesTab() {
        super("tabIndustrialMetallurgyResources");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.copper_ingot;
    }
}
