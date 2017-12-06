package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemInvarIngot extends Item {

    public ItemInvarIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.INVAR_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.INVAR_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
