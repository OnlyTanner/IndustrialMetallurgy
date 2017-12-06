package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemTitaniumHoe extends ItemHoe {

    public ItemTitaniumHoe() {
        super(ModItems.TITANIUM);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TITANIUM_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TITANIUM_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
