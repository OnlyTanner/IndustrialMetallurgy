package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemNitinolIngot extends Item {

    public ItemNitinolIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NITINOL_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NITINOL_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
