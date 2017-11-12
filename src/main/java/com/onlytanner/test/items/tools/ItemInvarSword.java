package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemInvarSword extends ItemSword {

    public ItemInvarSword() {
        super(ModItems.INVAR);
        setUnlocalizedName(Reference.TestModItems.INVAR_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.INVAR_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
