package com.onlytanner.test.init;

import com.onlytanner.test.GuiHandlerRegistry;
import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.blocks.BlockAluminumBlock;
import com.onlytanner.test.blocks.BlockBauxiteOre;
import com.onlytanner.test.blocks.BlockBellow;
import com.onlytanner.test.blocks.BlockBrassBlock;
import com.onlytanner.test.blocks.BlockBronzeBlock;
import com.onlytanner.test.blocks.BlockCassiteriteOre;
import com.onlytanner.test.blocks.BlockChromiteOre;
import com.onlytanner.test.blocks.BlockChromiumBlock;
import com.onlytanner.test.blocks.BlockCobaltiteOre;
import com.onlytanner.test.blocks.BlockCopperBlock;
import com.onlytanner.test.blocks.BlockCrusher;
import com.onlytanner.test.blocks.BlockCupriteOre;
import com.onlytanner.test.blocks.BlockForgeTier1;
import com.onlytanner.test.blocks.BlockGarnieriteOre;
import com.onlytanner.test.blocks.BlockInvarBlock;
import com.onlytanner.test.blocks.BlockIronForge;
import com.onlytanner.test.blocks.BlockIronForgeCore;
import com.onlytanner.test.blocks.BlockNichromeBlock;
import com.onlytanner.test.blocks.BlockNickelBlock;
import com.onlytanner.test.blocks.BlockNitinolBlock;
import com.onlytanner.test.blocks.BlockRefractoryBricks;
import com.onlytanner.test.blocks.BlockRutileOre;
import com.onlytanner.test.blocks.BlockSphaleriteOre;
import com.onlytanner.test.blocks.BlockSteelBlock;
import com.onlytanner.test.blocks.BlockTinBlock;
import com.onlytanner.test.blocks.BlockTitaniumBlock;
import com.onlytanner.test.blocks.BlockWolframiteOre;
import com.onlytanner.test.blocks.BlockZincBlock;
import com.onlytanner.test.handler.GuiHandlerCrusher;
import com.onlytanner.test.handler.GuiHandlerForgeTier1;
import com.onlytanner.test.tileentities.TileEntityCrusher;
import com.onlytanner.test.tileentities.TileEntityForgeTier1;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
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
	public static Block bellow;
	public static BlockContainer crusher;
	
	public static void init()
	{
		bauxite_ore = new BlockBauxiteOre();
		cassiterite_ore = new BlockCassiteriteOre();
		chromite_ore = new BlockChromiteOre();
		cobaltite_ore = new BlockCobaltiteOre();
		cuprite_ore = new BlockCupriteOre();
		garnierite_ore = new BlockGarnieriteOre();
		rutile_ore = new BlockRutileOre();
		sphalerite_ore = new BlockSphaleriteOre();
		wolframite_ore = new BlockWolframiteOre();
		
		aluminum_block = new BlockAluminumBlock();
		brass_block = new BlockBrassBlock();
		bronze_block = new BlockBronzeBlock();
		chromium_block = new BlockChromiumBlock();
		copper_block = new BlockCopperBlock();
		invar_block = new BlockInvarBlock();
		nichrome_block = new BlockNichromeBlock();
		nickel_block = new BlockNickelBlock();
		nitinol_block = new BlockNitinolBlock();
		steel_block = new BlockSteelBlock();
		tin_block = new BlockTinBlock();
		titanium_block = new BlockTitaniumBlock();
		zinc_block = new BlockZincBlock();
		
		refractory_bricks = new BlockRefractoryBricks();
		iron_forge_core = new BlockIronForgeCore();
		forge_tier1 = new BlockForgeTier1(false, Reference.TestModBlocks.FORGE_TIER1.getUnlocalizedName(), Reference.TestModBlocks.FORGE_TIER1.getRegistryName());
		crusher = new BlockCrusher(false, Reference.TestModBlocks.CRUSHER.getUnlocalizedName(), Reference.TestModBlocks.CRUSHER.getRegistryName());
		lit_forge_tier1 = new BlockForgeTier1(true, Reference.TestModBlocks.LIT_FORGE_TIER1.getUnlocalizedName(), Reference.TestModBlocks.LIT_FORGE_TIER1.getRegistryName());
		bellow = new BlockBellow();
	}
	
	public static void register()
	{
		registerBlock(cuprite_ore);
		registerBlock(cassiterite_ore);
		registerBlock(chromite_ore);
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
		registerBlock(bellow);
		registerBlock(crusher);
		
		GameRegistry.register(lit_forge_tier1);
		
		GameRegistry.registerTileEntity(TileEntityForgeTier1.class, "forge_tier1");
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "crusher");
		NetworkRegistry.INSTANCE.registerGuiHandler(TestMod.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerForgeTier1(), GuiHandlerForgeTier1.getGuiID());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerCrusher(), GuiHandlerCrusher.getGuiID());
	}
	
	private static void registerBlock(Block block)
	{
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(cuprite_ore);
		registerRender(cassiterite_ore);
		registerRender(chromite_ore);
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
		registerRender(bellow);
		registerRender(crusher);
	}
	
	private static void registerRender(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
