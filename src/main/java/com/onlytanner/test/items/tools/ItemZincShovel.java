package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemZincShovel extends ItemSpade {

    public ItemZincShovel() {
        super(ModItems.ZINC);
        setUnlocalizedName(Reference.TestModItems.ZINC_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ZINC_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
