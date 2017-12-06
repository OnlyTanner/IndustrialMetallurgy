package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemSteelNugget extends Item {

    public ItemSteelNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.STEEL_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.STEEL_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
