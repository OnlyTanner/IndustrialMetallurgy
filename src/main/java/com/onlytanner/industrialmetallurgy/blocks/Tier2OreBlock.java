package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Tier2OreBlock extends Block {

    public Tier2OreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(7.0f, 8.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

}
