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

    public static final IRecipeType<ForgeRecipe> FORGE_RECIPE_TYPE = registerType(IRecipeBase.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustrialMetallurgy.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> FORGE_SERIALIZER = RECIPE_SERIALIZERS.register("recipe", () -> FORGE_RECIPE_SERIALIZER);

    public static void init() {
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static IRecipeType<ForgeRecipe> registerType(ResourceLocation recipeTypeID) {
        return Registry.register(Registry.RECIPE_TYPE, recipeTypeID, new RecipeType<>());
    }

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

}
