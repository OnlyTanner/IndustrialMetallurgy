package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemTinIngot extends Item {

    public ItemTinIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TIN_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TIN_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
