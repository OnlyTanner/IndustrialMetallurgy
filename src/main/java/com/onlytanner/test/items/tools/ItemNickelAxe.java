package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemNickelAxe extends ItemAxe {

    public ItemNickelAxe() {
        super(ModItems.NICKEL, ModItems.NICKEL.getDamageVsEntity(), ModItems.NICKEL.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.NICKEL_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICKEL_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
