package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemCopperIngot extends Item {

    public ItemCopperIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
