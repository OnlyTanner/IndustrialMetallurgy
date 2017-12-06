package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIronForgeCore extends Block {

    public BlockIronForgeCore() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.IRON_FORGE_CORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.IRON_FORGE_CORE.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(IndustrialMetallurgy.SMELTING_TAB);
    }

}
