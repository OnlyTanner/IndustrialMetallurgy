package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemTitaniumAxe extends ItemAxe {

    public ItemTitaniumAxe() {
        super(ModItems.TITANIUM, ModItems.TITANIUM.getDamageVsEntity(), ModItems.TITANIUM.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.TestModItems.TITANIUM_AXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TITANIUM_AXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
