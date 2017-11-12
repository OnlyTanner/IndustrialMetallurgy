package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemBrassPickaxe extends ItemPickaxe {

    public ItemBrassPickaxe() {
        super(ModItems.BRASS);
        setUnlocalizedName(Reference.TestModItems.BRASS_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRASS_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
