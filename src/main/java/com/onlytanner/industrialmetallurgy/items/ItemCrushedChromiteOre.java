package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCrushedChromiteOre extends Item {

    public ItemCrushedChromiteOre() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CRUSHED_CHROMITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CRUSHED_CHROMITE_ORE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
