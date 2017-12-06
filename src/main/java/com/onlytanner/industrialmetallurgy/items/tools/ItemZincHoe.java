package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemZincHoe extends ItemHoe {

    public ItemZincHoe() {
        super(ModItems.ZINC);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ZINC_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ZINC_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
