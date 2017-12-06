package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCoalCoke extends Item {

    public ItemCoalCoke() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COAL_COKE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COAL_COKE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}