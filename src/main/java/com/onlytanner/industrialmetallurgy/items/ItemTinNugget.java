package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemTinNugget extends Item {

    public ItemTinNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TIN_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TIN_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
