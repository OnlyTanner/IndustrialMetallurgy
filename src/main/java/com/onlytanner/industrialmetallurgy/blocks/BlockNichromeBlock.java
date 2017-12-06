package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNichromeBlock extends Block {

    public BlockNichromeBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.NICHROME_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.NICHROME_BLOCK.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
