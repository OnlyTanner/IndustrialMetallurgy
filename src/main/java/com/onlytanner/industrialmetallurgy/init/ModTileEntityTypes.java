package com.onlytanner.industrialmetallurgy.init;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.tileentity.CrusherTileEntity;
import com.onlytanner.industrialmetallurgy.tileentity.ForgeTier1TileEntity;
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
    public static final RegistryObject<TileEntityType<CrusherTileEntity>> CRUSHER = TILE_ENTITY_TYPES.register("crusher", () -> TileEntityType.Builder.create(CrusherTileEntity::new, RegistryHandler.CRUSHER.get()).build(null));

}
