package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemBronzeShovel extends ItemSpade {

    public ItemBronzeShovel() {
        super(ModItems.BRONZE);
        setUnlocalizedName(Reference.TestModItems.BRONZE_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRONZE_SHOVEL.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
