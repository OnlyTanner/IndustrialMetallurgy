package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.item.Item;

public class ItemBronzeIngot extends Item {

    public ItemBronzeIngot() {
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRONZE_INGOT.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRONZE_INGOT.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
