package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemInvarAxe extends ItemAxe {

    public ItemInvarAxe() {
        super(ModItems.INVAR, ModItems.INVAR.getDamageVsEntity(), ModItems.INVAR.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.INVAR_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.INVAR_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
