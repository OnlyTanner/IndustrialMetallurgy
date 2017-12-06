package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemZincAxe extends ItemAxe {

    public ItemZincAxe() {
        super(ModItems.ZINC, ModItems.ZINC.getDamageVsEntity(), ModItems.ZINC.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ZINC_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ZINC_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
