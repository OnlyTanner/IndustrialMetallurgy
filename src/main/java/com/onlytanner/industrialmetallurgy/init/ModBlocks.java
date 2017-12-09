package com.onlytanner.industrialmetallurgy.init;

import com.onlytanner.industrialmetallurgy.GuiHandlerRegistry;
import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.Reference.IndustrialMetallurgyBlocks;
import com.onlytanner.industrialmetallurgy.blocks.BlockBase;
import com.onlytanner.industrialmetallurgy.blocks.BlockCoalGenerator;
import com.onlytanner.industrialmetallurgy.blocks.BlockCokeOven;
import com.onlytanner.industrialmetallurgy.blocks.BlockCrusher;
import com.onlytanner.industrialmetallurgy.blocks.BlockForgeTier1;
import com.onlytanner.industrialmetallurgy.handler.GuiHandlerCoalGenerator;
import com.onlytanner.industrialmetallurgy.handler.GuiHandlerCokeOven;
import com.onlytanner.industrialmetallurgy.handler.GuiHandlerCrusher;
import com.onlytanner.industrialmetallurgy.handler.GuiHandlerForgeTier1;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityCoalGenerator;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityCokeOven;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityCrusher;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityForgeTier1;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks 
{
    public static Block refractory_bricks;
    public static Block iron_forge_core;

    public static Block cuprite_ore;
    public static Block cassiterite_ore;
    public static Block chromite_ore;
    public static Block cobaltite_ore;
    public static Block sphalerite_ore;
    public static Block bauxite_ore;
    public static Block garnierite_ore;
    public static Block rutile_ore;
    public static Block wolframite_ore;

    public static Block aluminum_block;
    public static Block brass_block;
    public static Block bronze_block;
    public static Block chromium_block;
    public static Block copper_block;
    public static Block invar_block;
    public static Block nichrome_block;
    public static Block nickel_block;
    public static Block nitinol_block;
    public static Block steel_block;
    public static Block tin_block;
    public static Block titanium_block;
    public static Block zinc_block;

    public static BlockContainer forge_tier1;
    public static BlockContainer lit_forge_tier1;
    //public static Block bellow;
    public static BlockContainer crusher;
    public static BlockContainer coke_oven;
    public static BlockContainer lit_coke_oven;
    public static BlockContainer coal_generator;
    public static BlockContainer lit_coal_generator;

    public static void init() {
        bauxite_ore = new BlockBase(IndustrialMetallurgyBlocks.BAUXITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.BAUXITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        cassiterite_ore = new BlockBase(IndustrialMetallurgyBlocks.CASSITERITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.CASSITERITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        chromite_ore = new BlockBase(IndustrialMetallurgyBlocks.CHROMITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.CHROMITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        cobaltite_ore = new BlockBase(IndustrialMetallurgyBlocks.COBALTITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.COBALTITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        cuprite_ore = new BlockBase(IndustrialMetallurgyBlocks.CUPRITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.CUPRITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        garnierite_ore = new BlockBase(IndustrialMetallurgyBlocks.GARNIERITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.GARNIERITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        rutile_ore = new BlockBase(IndustrialMetallurgyBlocks.RUTILE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.RUTILE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        sphalerite_ore = new BlockBase(IndustrialMetallurgyBlocks.SPHALERITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.SPHALERITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        wolframite_ore = new BlockBase(IndustrialMetallurgyBlocks.WOLFRAMITE_ORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.WOLFRAMITE_ORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        
        bauxite_ore.setHarvestLevel("pickaxe", 1);
        cassiterite_ore.setHarvestLevel("pickaxe", 1);
        chromite_ore.setHarvestLevel("pickaxe", 2);
        cobaltite_ore.setHarvestLevel("pickaxe", 3);
        cuprite_ore.setHarvestLevel("pickaxe", 1);
        garnierite_ore.setHarvestLevel("pickaxe", 1);
        rutile_ore.setHarvestLevel("pickaxe", 2);
        sphalerite_ore.setHarvestLevel("pickaxe", 1);
        wolframite_ore.setHarvestLevel("pickaxe", 4);

        aluminum_block = new BlockBase(IndustrialMetallurgyBlocks.ALUMINUM_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.ALUMINUM_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        brass_block = new BlockBase(IndustrialMetallurgyBlocks.BRASS_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.BRASS_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        bronze_block = new BlockBase(IndustrialMetallurgyBlocks.BRONZE_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.BRONZE_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        chromium_block = new BlockBase(IndustrialMetallurgyBlocks.CHROMIUM_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.CHROMIUM_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        copper_block = new BlockBase(IndustrialMetallurgyBlocks.COPPER_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.COPPER_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        invar_block = new BlockBase(IndustrialMetallurgyBlocks.INVAR_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.INVAR_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        nichrome_block = new BlockBase(IndustrialMetallurgyBlocks.NICHROME_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.NICHROME_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        nickel_block = new BlockBase(IndustrialMetallurgyBlocks.NICKEL_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.NICKEL_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        nitinol_block = new BlockBase(IndustrialMetallurgyBlocks.NITINOL_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.NITINOL_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        steel_block = new BlockBase(IndustrialMetallurgyBlocks.STEEL_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.STEEL_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        tin_block = new BlockBase(IndustrialMetallurgyBlocks.TIN_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.TIN_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        titanium_block = new BlockBase(IndustrialMetallurgyBlocks.TITANIUM_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.TITANIUM_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        zinc_block = new BlockBase(IndustrialMetallurgyBlocks.ZINC_BLOCK.getUnlocalizedName(), IndustrialMetallurgyBlocks.ZINC_BLOCK.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);

        refractory_bricks = new BlockBase(IndustrialMetallurgyBlocks.REFRACTORY_BRICKS.getUnlocalizedName(), IndustrialMetallurgyBlocks.REFRACTORY_BRICKS.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.ROCK, 3.0F);
        iron_forge_core = new BlockBase(IndustrialMetallurgyBlocks.IRON_FORGE_CORE.getUnlocalizedName(), IndustrialMetallurgyBlocks.IRON_FORGE_CORE.getRegistryName(), IndustrialMetallurgy.RESOURCES_TAB, Material.IRON, 3.0F);
        
        forge_tier1 = new BlockForgeTier1(false, Reference.IndustrialMetallurgyBlocks.FORGE_TIER1.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.FORGE_TIER1.getRegistryName());
        crusher = new BlockCrusher(false, Reference.IndustrialMetallurgyBlocks.CRUSHER.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.CRUSHER.getRegistryName());
        lit_forge_tier1 = new BlockForgeTier1(true, Reference.IndustrialMetallurgyBlocks.LIT_FORGE_TIER1.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.LIT_FORGE_TIER1.getRegistryName());
        //bellow = new BlockBellow();
        coke_oven = new BlockCokeOven(false, Reference.IndustrialMetallurgyBlocks.COKE_OVEN.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.COKE_OVEN.getRegistryName());
        lit_coke_oven = new BlockCokeOven(true, Reference.IndustrialMetallurgyBlocks.LIT_COKE_OVEN.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.LIT_COKE_OVEN.getRegistryName());
        coal_generator = new BlockCoalGenerator(false, Reference.IndustrialMetallurgyBlocks.COAL_GENERATOR.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.COAL_GENERATOR.getRegistryName());
        lit_coal_generator = new BlockCoalGenerator(true, Reference.IndustrialMetallurgyBlocks.LIT_COAL_GENERATOR.getUnlocalizedName(), Reference.IndustrialMetallurgyBlocks.LIT_COAL_GENERATOR.getRegistryName());
    }

    public static void register() {
        registerBlock(cuprite_ore);
        registerBlock(cassiterite_ore);
        registerBlock(chromite_ore);
        registerBlock(cobaltite_ore);
        registerBlock(sphalerite_ore);
        registerBlock(bauxite_ore);
        registerBlock(garnierite_ore);
        registerBlock(rutile_ore);
        registerBlock(wolframite_ore);

        registerBlock(aluminum_block);
        registerBlock(brass_block);
        registerBlock(bronze_block);
        registerBlock(chromium_block);
        registerBlock(copper_block);
        registerBlock(invar_block);
        registerBlock(nichrome_block);
        registerBlock(nickel_block);
        registerBlock(nitinol_block);
        registerBlock(steel_block);
        registerBlock(tin_block);
        registerBlock(titanium_block);
        registerBlock(zinc_block);

        registerBlock(refractory_bricks);
        registerBlock(iron_forge_core);
        registerBlock(forge_tier1);
        //registerBlock(bellow);
        registerBlock(crusher);
        registerBlock(coke_oven);
        registerBlock(coal_generator);

        GameRegistry.register(lit_forge_tier1);
        GameRegistry.register(lit_coke_oven);
        GameRegistry.register(lit_coal_generator);

        GameRegistry.registerTileEntity(TileEntityForgeTier1.class, "forge_tier1");
        GameRegistry.registerTileEntity(TileEntityCrusher.class, "crusher");
        GameRegistry.registerTileEntity(TileEntityCokeOven.class, "coke_oven");
        GameRegistry.registerTileEntity(TileEntityCoalGenerator.class, "coal_generator");
        
        NetworkRegistry.INSTANCE.registerGuiHandler(IndustrialMetallurgy.instance, GuiHandlerRegistry.getInstance());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerForgeTier1(), GuiHandlerForgeTier1.getGuiID());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerCrusher(), GuiHandlerCrusher.getGuiID());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerCokeOven(), GuiHandlerCokeOven.getGuiID());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerCoalGenerator(), GuiHandlerCoalGenerator.getGuiID());
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    public static void registerRenders() {
        registerRender(cuprite_ore);
        registerRender(cassiterite_ore);
        registerRender(chromite_ore);
        registerRender(cobaltite_ore);
        registerRender(sphalerite_ore);
        registerRender(bauxite_ore);
        registerRender(garnierite_ore);
        registerRender(rutile_ore);
        registerRender(wolframite_ore);

        registerRender(aluminum_block);
        registerRender(brass_block);
        registerRender(bronze_block);
        registerRender(chromium_block);
        registerRender(copper_block);
        registerRender(invar_block);
        registerRender(nichrome_block);
        registerRender(nickel_block);
        registerRender(nitinol_block);
        registerRender(steel_block);
        registerRender(tin_block);
        registerRender(titanium_block);
        registerRender(zinc_block);

        registerRender(refractory_bricks);
        registerRender(iron_forge_core);
        registerRender(forge_tier1);
        registerRender(lit_forge_tier1);
        //registerRender(bellow);
        registerRender(crusher);
        registerRender(coal_generator);
        registerRender(lit_coal_generator);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
