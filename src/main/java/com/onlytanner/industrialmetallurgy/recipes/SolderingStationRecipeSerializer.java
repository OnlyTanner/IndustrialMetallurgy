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

public class SolderingStationRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SolderingStationRecipe> {

    @Override
    public SolderingStationRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), true);
        Ingredient input = Ingredient.deserialize(JSONUtils.getJsonArray(json, "input"));
        return new SolderingStationRecipe(recipeId, input, output);
    }

    @Nullable
    @Override
    public SolderingStationRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        Ingredient input = Ingredient.read(buffer);
        return new SolderingStationRecipe(recipeId, input, output);
    }

    @Override
    public void write(PacketBuffer buffer, SolderingStationRecipe recipe) {
        Ingredient input = recipe.getIngredients().get(0);
        input.write(buffer);
        buffer.writeItemStack(recipe.getRecipeOutput(), false);
    }

}
