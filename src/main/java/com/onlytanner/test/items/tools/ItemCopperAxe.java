package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemCopperAxe extends ItemAxe {

    public ItemCopperAxe() {
        super(ModItems.COPPER, ModItems.COPPER.getDamageVsEntity(), ModItems.COPPER.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.COPPER_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COPPER_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
