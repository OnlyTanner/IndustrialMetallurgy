package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemChromiumIngot extends Item {

    public ItemChromiumIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CHROMIUM_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CHROMIUM_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
