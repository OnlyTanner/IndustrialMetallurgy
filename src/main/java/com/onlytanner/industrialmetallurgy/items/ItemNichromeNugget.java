package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemNichromeNugget extends Item {

    public ItemNichromeNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICHROME_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICHROME_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
