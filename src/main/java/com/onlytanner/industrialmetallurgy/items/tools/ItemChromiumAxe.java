package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemChromiumAxe extends ItemAxe {

    public ItemChromiumAxe() {
        super(ModItems.CHROMIUM, ModItems.CHROMIUM.getDamageVsEntity(), ModItems.CHROMIUM.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CHROMIUM_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CHROMIUM_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
