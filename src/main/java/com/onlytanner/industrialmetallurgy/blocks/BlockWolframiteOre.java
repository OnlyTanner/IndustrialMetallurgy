package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWolframiteOre extends Block {

    public BlockWolframiteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.WOLFRAMITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.WOLFRAMITE_ORE.getRegistryName());
        setHardness(12.0F);
        setHarvestLevel("pickaxe", 4);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
