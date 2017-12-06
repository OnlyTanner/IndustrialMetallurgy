package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemTungstenSword extends ItemSword {

    public ItemTungstenSword() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.TestModItems.TUNGSTEN_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TUNGSTEN_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
