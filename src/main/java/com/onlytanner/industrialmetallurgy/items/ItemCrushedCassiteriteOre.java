package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCrushedCassiteriteOre extends Item {

    public ItemCrushedCassiteriteOre() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CRUSHED_CASSITERITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CRUSHED_CASSITERITE_ORE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
