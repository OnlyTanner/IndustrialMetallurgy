package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Tier3OreBlock extends Block {

    public Tier3OreBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(7.0f, 8.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .setRequiresTool()  // set requires tool
                .harvestTool(ToolType.PICKAXE));
    }

}
