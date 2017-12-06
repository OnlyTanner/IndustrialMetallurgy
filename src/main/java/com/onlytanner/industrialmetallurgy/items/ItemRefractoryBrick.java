package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemRefractoryBrick extends Item {

    public ItemRefractoryBrick() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.REFRACTORY_BRICK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.REFRACTORY_BRICK.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.SMELTING_TAB);
    }
}
