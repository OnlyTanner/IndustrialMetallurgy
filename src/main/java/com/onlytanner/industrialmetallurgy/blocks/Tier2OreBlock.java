package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Tier2OreBlock extends OreBlock {

    public Tier2OreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .setRequiresTool()  // set requires tool
                .harvestTool(ToolType.PICKAXE));
    }

}
