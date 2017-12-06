package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRefractoryBricks extends Block {

    public BlockRefractoryBricks() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.REFRACTORY_BRICKS.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.REFRACTORY_BRICKS.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(IndustrialMetallurgy.SMELTING_TAB);
    }

}
