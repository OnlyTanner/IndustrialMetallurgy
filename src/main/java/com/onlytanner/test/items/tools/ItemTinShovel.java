package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemTinShovel extends ItemSpade {

    public ItemTinShovel() {
        super(ModItems.TIN);
        setUnlocalizedName(Reference.TestModItems.TIN_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TIN_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
