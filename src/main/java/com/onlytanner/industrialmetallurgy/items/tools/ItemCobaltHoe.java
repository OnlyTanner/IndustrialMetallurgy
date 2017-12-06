package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemCobaltHoe extends ItemHoe {

    public ItemCobaltHoe() {
        super(ModItems.COBALT);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COBALT_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COBALT_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
