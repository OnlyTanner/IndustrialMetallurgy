package com.onlytanner.industrialmetallurgy;

import com.onlytanner.industrialmetallurgy.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IndustrialMetallurgySmeltingTab extends CreativeTabs {

    public IndustrialMetallurgySmeltingTab() {
        super("tabIndustrialMetallurgySmelting");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ModBlocks.forge_tier1);
    }
}
