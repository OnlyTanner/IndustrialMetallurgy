package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemTitaniumNugget extends Item {

    public ItemTitaniumNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TITANIUM_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TITANIUM_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
