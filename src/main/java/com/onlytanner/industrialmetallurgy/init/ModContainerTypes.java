package com.onlytanner.industrialmetallurgy.init;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.containers.*;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, IndustrialMetallurgy.MOD_ID);

    public static void init() {
        CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<ContainerType<ForgeTier1Container>> FORGE_TIER1 = CONTAINER_TYPES.register("forge_tier1", () -> IForgeContainerType.create(ForgeTier1Container::new));
    public static final RegistryObject<ContainerType<ForgeTier2Container>> FORGE_TIER2 = CONTAINER_TYPES.register("forge_tier2", () -> IForgeContainerType.create(ForgeTier2Container::new));
    public static final RegistryObject<ContainerType<ForgeTier3Container>> FORGE_TIER3 = CONTAINER_TYPES.register("forge_tier3", () -> IForgeContainerType.create(ForgeTier3Container::new));
    public static final RegistryObject<ContainerType<ForgeTier4Container>> FORGE_TIER4 = CONTAINER_TYPES.register("forge_tier4", () -> IForgeContainerType.create(ForgeTier4Container::new));
    public static final RegistryObject<ContainerType<CrusherContainer>> CRUSHER = CONTAINER_TYPES.register("crusher", () -> IForgeContainerType.create(CrusherContainer::new));
    public static final RegistryObject<ContainerType<CokeOvenContainer>> COKE_OVEN = CONTAINER_TYPES.register("coke_oven", () -> IForgeContainerType.create(CokeOvenContainer::new));
    public static final RegistryObject<ContainerType<ChemicalCentrifugeContainer>> CHEMICAL_CENTRIFUGE = CONTAINER_TYPES.register("chemical_centrifuge", () -> IForgeContainerType.create(ChemicalCentrifugeContainer::new));
    public static final RegistryObject<ContainerType<ChemicalReactorContainer>> CHEMICAL_REACTOR = CONTAINER_TYPES.register("chemical_reactor", () -> IForgeContainerType.create(ChemicalReactorContainer::new));
    public static final RegistryObject<ContainerType<ExtruderContainer>> EXTRUDER = CONTAINER_TYPES.register("extruder", () -> IForgeContainerType.create(ExtruderContainer::new));
    public static final RegistryObject<ContainerType<SolderingStationContainer>> SOLDERING_STATION = CONTAINER_TYPES.register("soldering_station", () -> IForgeContainerType.create(SolderingStationContainer::new));
    public static final RegistryObject<ContainerType<ThermoelectricGeneratorContainer>> THERMOELECTRIC_GENERATOR = CONTAINER_TYPES.register("thermoelectric_generator", () -> IForgeContainerType.create(ThermoelectricGeneratorContainer::new));

}
