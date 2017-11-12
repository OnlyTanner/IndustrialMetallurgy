package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemTitaniumShovel extends ItemSpade {

    public ItemTitaniumShovel() {
        super(ModItems.TITANIUM);
        setUnlocalizedName(Reference.TestModItems.TITANIUM_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TITANIUM_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
