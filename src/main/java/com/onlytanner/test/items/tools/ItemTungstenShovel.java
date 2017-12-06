package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemTungstenShovel extends ItemSpade {

    public ItemTungstenShovel() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.TestModItems.TUNGSTEN_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TUNGSTEN_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
