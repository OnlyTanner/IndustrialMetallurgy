package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemAluminumNugget extends Item {

    public ItemAluminumNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ALUMINUM_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ALUMINUM_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
