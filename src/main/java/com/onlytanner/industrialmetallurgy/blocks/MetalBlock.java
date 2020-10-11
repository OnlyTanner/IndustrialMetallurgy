package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MetalBlock extends Block {

    public MetalBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));
    }

}
