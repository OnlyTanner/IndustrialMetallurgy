package com.onlytanner.industrialmetallurgy.recipes;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {

    public static final IRecipeSerializer<ForgeRecipe> FORGE_RECIPE_SERIALIZER = new ForgeRecipeSerializer();
    public static final IRecipeSerializer<CrusherRecipe> CRUSHER_RECIPE_SERIALIZER = new CrusherRecipeSerializer();
    public static final IRecipeSerializer<CokeOvenRecipe> COKE_OVEN_RECIPE_SERIALIZER = new CokeOvenRecipeSerializer();
    public static final IRecipeSerializer<ChemicalCentrifugeRecipe> CHEMICAL_CENTRIFUGE_RECIPE_SERIALIZER = new ChemicalCentrifugeRecipeSerializer();
    public static final IRecipeSerializer<ChemicalReactorRecipe> CHEMICAL_REACTOR_RECIPE_SERIALIZER = new ChemicalReactorRecipeSerializer();
    public static final IRecipeSerializer<ExtruderRecipe> EXTRUDER_RECIPE_SERIALIZER = new ExtruderRecipeSerializer();
    public static final IRecipeSerializer<SolderingStationRecipe> SOLDERING_STATION_RECIPE_SERIALIZER = new SolderingStationRecipeSerializer();

    public static final IRecipeType<ForgeRecipe> FORGE_RECIPE_TYPE = (IRecipeType<ForgeRecipe>) registerType(ForgeRecipeBase.RECIPE_TYPE_ID);
    public static final IRecipeType<CrusherRecipe> CRUSHER_RECIPE_TYPE = (IRecipeType<CrusherRecipe>) registerType(CrusherRecipeBase.RECIPE_TYPE_ID);
    public static final IRecipeType<CokeOvenRecipe> COKE_OVEN_RECIPE_TYPE = (IRecipeType<CokeOvenRecipe>) registerType(CokeOvenRecipeBase.RECIPE_TYPE_ID);
    public static final IRecipeType<ChemicalCentrifugeRecipe> CHEMICAL_CENTRIFUGE_RECIPE_TYPE = (IRecipeType<ChemicalCentrifugeRecipe>) registerType(ChemicalCentrifugeRecipeBase.RECIPE_TYPE_ID);
    public static final IRecipeType<ChemicalReactorRecipe> CHEMICAL_REACTOR_RECIPE_TYPE = (IRecipeType<ChemicalReactorRecipe>) registerType(ChemicalReactorRecipeBase.RECIPE_TYPE_ID);
    public static final IRecipeType<ExtruderRecipe> EXTRUDER_RECIPE_RECIPE_TYPE = (IRecipeType<ExtruderRecipe>) registerType(ExtruderRecipeBase.RECIPE_TYPE_ID);
    public static final IRecipeType<SolderingStationRecipe> SOLDERING_STATION_RECIPE_TYPE = (IRecipeType<SolderingStationRecipe>) registerType(SolderingStationRecipeBase.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustrialMetallurgy.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> FORGE_SERIALIZER = RECIPE_SERIALIZERS.register("forge", () -> FORGE_RECIPE_SERIALIZER);
    public static final RegistryObject<IRecipeSerializer<?>> CRUSHER_SERIALIZER = RECIPE_SERIALIZERS.register("crusher", () -> CRUSHER_RECIPE_SERIALIZER);
    public static final RegistryObject<IRecipeSerializer<?>> COKE_OVEN_SERIALIZER = RECIPE_SERIALIZERS.register("coke_oven", () -> COKE_OVEN_RECIPE_SERIALIZER);
    public static final RegistryObject<IRecipeSerializer<?>> CHEMICAL_CENTRIFUGE_SERIALIZER = RECIPE_SERIALIZERS.register("chemical_centrifuge", () -> CHEMICAL_CENTRIFUGE_RECIPE_SERIALIZER);
    public static final RegistryObject<IRecipeSerializer<?>> CHEMICAL_REACTOR_SERIALIZER = RECIPE_SERIALIZERS.register("chemical_reactor", () -> CHEMICAL_REACTOR_RECIPE_SERIALIZER);
    public static final RegistryObject<IRecipeSerializer<?>> EXTRUDER_SERIALIZER = RECIPE_SERIALIZERS.register("extruder", () -> EXTRUDER_RECIPE_SERIALIZER);
    public static final RegistryObject<IRecipeSerializer<?>> SOLDERING_STATION_SERIALIZER = RECIPE_SERIALIZERS.register("soldering_station", () -> SOLDERING_STATION_RECIPE_SERIALIZER);

    public static void init() {
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static IRecipeType<?> registerType(ResourceLocation recipeTypeID) {
        return Registry.register(Registry.RECIPE_TYPE, recipeTypeID, new RecipeType<>());
    }

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

}
