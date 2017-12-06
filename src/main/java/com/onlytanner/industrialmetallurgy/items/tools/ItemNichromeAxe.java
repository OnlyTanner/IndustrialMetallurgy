package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemNichromeAxe extends ItemAxe {

    public ItemNichromeAxe() {
        super(ModItems.NICHROME, ModItems.NICHROME.getDamageVsEntity(), ModItems.NICHROME.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICHROME_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICHROME_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
