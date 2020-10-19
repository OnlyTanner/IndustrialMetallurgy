package com.onlytanner.industrialmetallurgy.client.gui;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = IndustrialMetallurgy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ScreenHandler {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent e) {
        ScreenManager.registerFactory(ModContainerTypes.FORGE_TIER1.get(), ForgeTier1Screen::new);
    }

}
