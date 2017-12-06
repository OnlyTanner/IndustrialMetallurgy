package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemCobaltPickaxe extends ItemPickaxe {

    public ItemCobaltPickaxe() {
        super(ModItems.COBALT);
        setUnlocalizedName(Reference.TestModItems.COBALT_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COBALT_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
