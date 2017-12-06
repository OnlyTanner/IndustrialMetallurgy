package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemTungstenAxe extends ItemAxe {

    public ItemTungstenAxe() {
        super(ModItems.TUNGSTEN, ModItems.TUNGSTEN.getDamageVsEntity(), ModItems.TUNGSTEN.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.TUNGSTEN_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TUNGSTEN_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
