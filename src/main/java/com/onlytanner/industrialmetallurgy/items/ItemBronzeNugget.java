package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemBronzeNugget extends Item {

    public ItemBronzeNugget() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRONZE_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRONZE_NUGGET.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
