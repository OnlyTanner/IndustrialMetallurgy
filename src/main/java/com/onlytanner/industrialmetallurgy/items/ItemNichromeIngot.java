package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemNichromeIngot extends Item {

    public ItemNichromeIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICHROME_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICHROME_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
