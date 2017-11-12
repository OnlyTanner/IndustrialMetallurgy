package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIronForgeCore extends Block {

    public BlockIronForgeCore() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.TestModBlocks.IRON_FORGE_CORE.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.IRON_FORGE_CORE.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(TestMod.SMELTING_TAB);
    }

}
