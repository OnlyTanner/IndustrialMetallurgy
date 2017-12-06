package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemBrassIngot extends Item {

    public ItemBrassIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRASS_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRASS_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
