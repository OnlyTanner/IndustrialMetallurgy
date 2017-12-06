package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemTungstenPickaxe extends ItemPickaxe {

    public ItemTungstenPickaxe() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.TestModItems.TUNGSTEN_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TUNGSTEN_PICKAXE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
