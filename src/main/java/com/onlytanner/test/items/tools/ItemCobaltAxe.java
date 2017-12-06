package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemCobaltAxe extends ItemAxe {

    public ItemCobaltAxe() {
        super(ModItems.COBALT, ModItems.COBALT.getDamageVsEntity(), ModItems.COBALT.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.COBALT_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COBALT_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
