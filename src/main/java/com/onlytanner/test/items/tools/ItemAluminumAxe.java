package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemAluminumAxe extends ItemAxe {

    public ItemAluminumAxe() {
        super(ModItems.ALUMINUM, ModItems.ALUMINUM.getDamageVsEntity(), ModItems.ALUMINUM.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.ALUMINUM_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ALUMINUM_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
