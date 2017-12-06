package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemBronzeHoe extends ItemHoe {

    public ItemBronzeHoe() {
        super(ModItems.BRONZE);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRONZE_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRONZE_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
