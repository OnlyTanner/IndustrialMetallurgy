package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemRefractoryComposite extends Item {

    public ItemRefractoryComposite() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.REFRACTORY_COMPOSITE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.REFRACTORY_COMPOSITE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.SMELTING_TAB);
    }

}
