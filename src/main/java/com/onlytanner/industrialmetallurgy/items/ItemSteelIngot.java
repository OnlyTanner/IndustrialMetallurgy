package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemSteelIngot extends Item {

    public ItemSteelIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.STEEL_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.STEEL_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
