package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemCopperHoe extends ItemHoe {

    public ItemCopperHoe() {
        super(ModItems.COPPER);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
