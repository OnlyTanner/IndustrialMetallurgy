package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemInvarShovel extends ItemSpade {

    public ItemInvarShovel() {
        super(ModItems.INVAR);
        setUnlocalizedName(Reference.TestModItems.INVAR_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.INVAR_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
