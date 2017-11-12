package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemBronzePickaxe extends ItemPickaxe {

    public ItemBronzePickaxe() {
        super(ModItems.BRONZE);
        setUnlocalizedName(Reference.TestModItems.BRONZE_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRONZE_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
