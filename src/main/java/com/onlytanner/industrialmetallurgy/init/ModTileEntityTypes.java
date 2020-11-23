package com.onlytanner.industrialmetallurgy.init;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.blocks.ChemicalCentrifugeBlock;
import com.onlytanner.industrialmetallurgy.tileentity.*;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, IndustrialMetallurgy.MOD_ID);

    public static void init() {
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TileEntityType<ForgeTier1TileEntity>> FORGE_TIER1 = TILE_ENTITY_TYPES.register("forge_tier1", () -> TileEntityType.Builder.create(ForgeTier1TileEntity::new, RegistryHandler.FORGE_TIER1.get()).build(null));
    public static final RegistryObject<TileEntityType<ForgeTier2TileEntity>> FORGE_TIER2 = TILE_ENTITY_TYPES.register("forge_tier2", () -> TileEntityType.Builder.create(ForgeTier2TileEntity::new, RegistryHandler.FORGE_TIER2.get()).build(null));
    public static final RegistryObject<TileEntityType<ForgeTier3TileEntity>> FORGE_TIER3 = TILE_ENTITY_TYPES.register("forge_tier3", () -> TileEntityType.Builder.create(ForgeTier3TileEntity::new, RegistryHandler.FORGE_TIER3.get()).build(null));
    public static final RegistryObject<TileEntityType<ForgeTier4TileEntity>> FORGE_TIER4 = TILE_ENTITY_TYPES.register("forge_tier4", () -> TileEntityType.Builder.create(ForgeTier4TileEntity::new, RegistryHandler.FORGE_TIER4.get()).build(null));
    public static final RegistryObject<TileEntityType<CrusherTileEntity>> CRUSHER = TILE_ENTITY_TYPES.register("crusher", () -> TileEntityType.Builder.create(CrusherTileEntity::new, RegistryHandler.CRUSHER.get()).build(null));
    public static final RegistryObject<TileEntityType<CokeOvenTileEntity>> COKE_OVEN = TILE_ENTITY_TYPES.register("coke_oven", () -> TileEntityType.Builder.create(CokeOvenTileEntity::new, RegistryHandler.COKE_OVEN.get()).build(null));
    public static final RegistryObject<TileEntityType<ChemicalCentrifugeTileEntity>> CHEMICAL_CENTRIFUGE = TILE_ENTITY_TYPES.register("chemical_centrifuge", () -> TileEntityType.Builder.create(ChemicalCentrifugeTileEntity::new, RegistryHandler.CHEMICAL_CENTRIFUGE.get()).build(null));
    public static final RegistryObject<TileEntityType<ChemicalReactorTileEntity>> CHEMICAL_REACTOR = TILE_ENTITY_TYPES.register("chemical_reactor", () -> TileEntityType.Builder.create(ChemicalReactorTileEntity::new, RegistryHandler.CHEMICAL_REACTOR.get()).build(null));
    public static final RegistryObject<TileEntityType<ExtruderTileEntity>> EXTRUDER = TILE_ENTITY_TYPES.register("extruder", () -> TileEntityType.Builder.create(ExtruderTileEntity::new, RegistryHandler.EXTRUDER.get()).build(null));
    public static final RegistryObject<TileEntityType<SolderingStationTileEntity>> SOLDERING_STATION = TILE_ENTITY_TYPES.register("soldering_station", () -> TileEntityType.Builder.create(SolderingStationTileEntity::new, RegistryHandler.SOLDERING_STATION.get()).build(null));
    public static final RegistryObject<TileEntityType<ThermoelectricGeneratorTileEntity>> THERMOELECTRIC_GENERATOR = TILE_ENTITY_TYPES.register("thermoelectric_generator", () -> TileEntityType.Builder.create(ThermoelectricGeneratorTileEntity::new, RegistryHandler.THERMOELECTRIC_GENERATOR.get()).build(null));

}
