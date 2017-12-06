package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemZincNugget extends Item {

    public ItemZincNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ZINC_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ZINC_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
