package com.onlytanner.industrialmetallurgy.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class ChemicalReactorRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ChemicalReactorRecipe> {

    @Override
    public ChemicalReactorRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), true);
        Ingredient input = Ingredient.deserialize(JSONUtils.getJsonArray(json, "input"));
        return new ChemicalReactorRecipe(recipeId, input, output);
    }

    @Nullable
    @Override
    public ChemicalReactorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        Ingredient input = Ingredient.read(buffer);
        return new ChemicalReactorRecipe(recipeId, input, output);
    }

    @Override
    public void write(PacketBuffer buffer, ChemicalReactorRecipe recipe) {
        Ingredient input = recipe.getIngredients().get(0);
        input.write(buffer);
        buffer.writeItemStack(recipe.getRecipeOutput(), false);
    }

}
