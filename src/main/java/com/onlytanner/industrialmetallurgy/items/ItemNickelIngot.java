package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemNickelIngot extends Item {

    public ItemNickelIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICKEL_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICKEL_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
