package com.onlytanner.industrialmetallurgy;

import com.onlytanner.industrialmetallurgy.client.gui.CokeOvenScreen;
import com.onlytanner.industrialmetallurgy.client.gui.CrusherScreen;
import com.onlytanner.industrialmetallurgy.client.gui.ForgeTier1Screen;
import com.onlytanner.industrialmetallurgy.client.gui.ThermoelectricGeneratorScreen;
import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import com.onlytanner.industrialmetallurgy.recipes.RecipeSerializerInit;
import com.onlytanner.industrialmetallurgy.util.ConfigHandler;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import com.onlytanner.industrialmetallurgy.world.gen.OreGenHandler;
import com.onlytanner.industrialmetallurgy.world.gen.feature.OreFeatureHandler;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("industrialmetallurgy")
public class IndustrialMetallurgy
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "industrialmetallurgy";

    public IndustrialMetallurgy() {
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

        // Registers and Loads Config File
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_CONFIG);
        ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("industrialmetallurgy-common.toml"));

        RegistryHandler.init();
        RecipeSerializerInit.init();
        ModContainerTypes.init();
        ModTileEntityTypes.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreFeatureHandler.initModFeatures();
        OreGenHandler.generateOres();
    }

    @OnlyIn(Dist.CLIENT)
    private void setupClient(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainerTypes.FORGE_TIER1.get(), ForgeTier1Screen::new);
        ScreenManager.registerFactory(ModContainerTypes.CRUSHER.get(), CrusherScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.COKE_OVEN.get(), CokeOvenScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.THERMOELECTRIC_GENERATOR.get(), ThermoelectricGeneratorScreen::new);
    }

    public static final ItemGroup TAB = new ItemGroup("industrialMetallurgy") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.TUNGSTEN_INGOT.get());
        }
    };

}
