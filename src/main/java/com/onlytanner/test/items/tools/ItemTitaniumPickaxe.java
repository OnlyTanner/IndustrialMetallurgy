package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemTitaniumPickaxe extends ItemPickaxe {

    public ItemTitaniumPickaxe() {
        super(ModItems.TITANIUM);
        setUnlocalizedName(Reference.TestModItems.TITANIUM_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TITANIUM_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
