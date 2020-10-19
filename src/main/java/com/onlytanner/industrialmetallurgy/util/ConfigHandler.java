package com.onlytanner.industrialmetallurgy.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.onlytanner.industrialmetallurgy.config.OreGenConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class ConfigHandler {

    public static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;

    static
    {
        //Loaded from class in Config folder
        OreGenConfig.Init(COMMON_BUILDER);

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path file)
    {
        final CommentedFileConfig configData = CommentedFileConfig.builder(file)
                .sync()
                .autosave()
                .autoreload()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }

}
