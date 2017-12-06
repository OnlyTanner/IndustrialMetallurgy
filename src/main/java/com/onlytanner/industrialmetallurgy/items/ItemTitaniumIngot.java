package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemTitaniumIngot extends Item {

    public ItemTitaniumIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TITANIUM_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TITANIUM_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
