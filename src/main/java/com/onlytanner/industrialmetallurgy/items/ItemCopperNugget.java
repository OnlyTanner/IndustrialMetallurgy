package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCopperNugget extends Item {

    public ItemCopperNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
