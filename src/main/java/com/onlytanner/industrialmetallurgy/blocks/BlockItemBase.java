package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(IndustrialMetallurgy.TAB));
    }

}
