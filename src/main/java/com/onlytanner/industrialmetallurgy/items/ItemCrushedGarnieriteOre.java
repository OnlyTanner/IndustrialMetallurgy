package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCrushedGarnieriteOre extends Item {

    public ItemCrushedGarnieriteOre() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CRUSHED_GARNIERITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CRUSHED_GARNIERITE_ORE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
