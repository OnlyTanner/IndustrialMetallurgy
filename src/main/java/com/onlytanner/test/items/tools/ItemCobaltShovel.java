package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemCobaltShovel extends ItemSpade {

    public ItemCobaltShovel() {
        super(ModItems.COBALT);
        setUnlocalizedName(Reference.TestModItems.COBALT_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COBALT_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
