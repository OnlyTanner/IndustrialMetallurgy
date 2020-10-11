package com.onlytanner.industrialmetallurgy.init;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.blocks.ForgeTier1Block;
import com.onlytanner.industrialmetallurgy.tileentities.ForgeTier1TileEntity;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, IndustrialMetallurgy.MOD_ID);

    public static final RegistryObject<TileEntityType<ForgeTier1TileEntity>> FORGE_TIER1 = TILE_ENTITY_TYPES.register("forge_tier1", () -> TileEntityType.Builder.create(ForgeTier1TileEntity::new, RegistryHandler.FORGE_TIER1.get()).build(null));

}
