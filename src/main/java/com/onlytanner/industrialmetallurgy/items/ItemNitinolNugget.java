package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemNitinolNugget extends Item {

    public ItemNitinolNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NITINOL_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NITINOL_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
