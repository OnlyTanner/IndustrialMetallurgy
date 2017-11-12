package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemNichromePickaxe extends ItemPickaxe {

    public ItemNichromePickaxe() {
        super(ModItems.NICHROME);
        setUnlocalizedName(Reference.TestModItems.NICHROME_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICHROME_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
