package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemBrassNugget extends Item {

    public ItemBrassNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRASS_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRASS_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
