package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobaltiteOre extends Block {

    public BlockCobaltiteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.COBALTITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.COBALTITE_ORE.getRegistryName());
        setHardness(8.0F);
        setHarvestLevel("pickaxe", 3);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
