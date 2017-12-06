package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemTungstenIngot extends Item {

    public ItemTungstenIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TUNGSTEN_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TUNGSTEN_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
