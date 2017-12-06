package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCrushedBauxiteOre extends Item {

    public ItemCrushedBauxiteOre() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CRUSHED_BAUXITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CRUSHED_BAUXITE_ORE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
