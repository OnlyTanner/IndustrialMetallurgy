package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemIronNugget extends Item {

    public ItemIronNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.IRON_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.IRON_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
