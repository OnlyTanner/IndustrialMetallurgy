package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNichromeBlock extends Block {

    public BlockNichromeBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.TestModBlocks.NICHROME_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.NICHROME_BLOCK.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
