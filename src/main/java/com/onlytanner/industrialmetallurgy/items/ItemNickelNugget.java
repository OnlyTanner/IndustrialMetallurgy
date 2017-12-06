package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemNickelNugget extends Item {

    public ItemNickelNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICKEL_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICKEL_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
