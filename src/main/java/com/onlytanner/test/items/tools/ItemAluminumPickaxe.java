package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemAluminumPickaxe extends ItemPickaxe {

    public ItemAluminumPickaxe() {
        super(ModItems.ALUMINUM);
        setUnlocalizedName(Reference.TestModItems.ALUMINUM_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ALUMINUM_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
