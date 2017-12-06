package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemNickelHoe extends ItemHoe {

    public ItemNickelHoe() {
        super(ModItems.NICKEL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICKEL_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICKEL_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
