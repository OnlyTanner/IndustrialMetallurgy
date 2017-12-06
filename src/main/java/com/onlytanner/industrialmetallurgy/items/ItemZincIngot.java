package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemZincIngot extends Item {

    public ItemZincIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ZINC_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ZINC_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
