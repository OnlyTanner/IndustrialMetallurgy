package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemCopperPickaxe extends ItemPickaxe {

    public ItemCopperPickaxe() {
        super(ModItems.COPPER);
        setUnlocalizedName(Reference.TestModItems.COPPER_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COPPER_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
