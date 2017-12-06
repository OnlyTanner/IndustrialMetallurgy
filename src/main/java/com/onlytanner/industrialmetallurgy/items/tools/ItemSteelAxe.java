package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemSteelAxe extends ItemAxe {

    public ItemSteelAxe() {
        super(ModItems.STEEL, ModItems.STEEL.getDamageVsEntity(), ModItems.STEEL.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.STEEL_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.STEEL_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
