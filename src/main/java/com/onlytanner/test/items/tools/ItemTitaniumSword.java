package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemTitaniumSword extends ItemSword {

    public ItemTitaniumSword() {
        super(ModItems.TITANIUM);
        setUnlocalizedName(Reference.TestModItems.TITANIUM_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TITANIUM_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
