package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemZincAxe extends ItemAxe {

    public ItemZincAxe() {
        super(ModItems.ZINC, ModItems.ZINC.getDamageVsEntity(), ModItems.ZINC.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.ZINC_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ZINC_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
