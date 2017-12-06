package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRutileOre extends Block {

    public BlockRutileOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.RUTILE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.RUTILE_ORE.getRegistryName());
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }

}
