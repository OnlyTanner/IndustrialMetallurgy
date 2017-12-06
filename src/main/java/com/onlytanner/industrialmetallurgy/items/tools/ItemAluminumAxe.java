package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemAluminumAxe extends ItemAxe {

    public ItemAluminumAxe() {
        super(ModItems.ALUMINUM, ModItems.ALUMINUM.getDamageVsEntity(), ModItems.ALUMINUM.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ALUMINUM_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ALUMINUM_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
