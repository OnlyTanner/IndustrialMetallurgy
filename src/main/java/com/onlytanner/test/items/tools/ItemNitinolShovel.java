package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemNitinolShovel extends ItemSpade {

    public ItemNitinolShovel() {
        super(ModItems.NITINOL);
        setUnlocalizedName(Reference.TestModItems.NITINOL_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NITINOL_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
