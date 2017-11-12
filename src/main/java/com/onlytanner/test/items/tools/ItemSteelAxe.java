package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemSteelAxe extends ItemAxe {

    public ItemSteelAxe() {
        super(ModItems.STEEL, ModItems.STEEL.getDamageVsEntity(), ModItems.STEEL.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.STEEL_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.STEEL_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
