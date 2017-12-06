package com.onlytanner.industrialmetallurgy;

import com.onlytanner.industrialmetallurgy.init.ModBlocks;
import com.onlytanner.industrialmetallurgy.init.ModCrafting;
import com.onlytanner.industrialmetallurgy.init.ModItems;
import com.onlytanner.industrialmetallurgy.proxy.CommonProxy;
import com.onlytanner.industrialmetallurgy.world.ModWorldGen;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class IndustrialMetallurgy {

    @Instance
    public static IndustrialMetallurgy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTabs RESOURCES_TAB = new IndustrialMetallurgyResourcesTab();
    public static final CreativeTabs TOOLS_TAB = new IndustrialMetallurgyToolsTab();
    public static final CreativeTabs SMELTING_TAB = new IndustrialMetallurgySmeltingTab();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModItems.register();

        ModBlocks.init();
        ModBlocks.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        ModCrafting.register();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
