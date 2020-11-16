package com.onlytanner.industrialmetallurgy.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
import java.util.LinkedList;
import java.util.List;

public class ChemicalCentrifugeRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ChemicalCentrifugeRecipe> {

    @Override
    public ChemicalCentrifugeRecipe read(ResourceLocation recipeId, JsonObject json) {
        List<ItemStack> output = new LinkedList<>();
        JsonArray arr = JSONUtils.getJsonArray(json, "output");
        for (JsonElement elem : arr) {
            output.add(CraftingHelper.getItemStack(elem.getAsJsonObject(), true));
        }
        Ingredient input = Ingredient.deserialize(JSONUtils.getJsonArray(json, "input"));
        return new ChemicalCentrifugeRecipe(recipeId, input, output);
    }

    @Nullable
    @Override
    public ChemicalCentrifugeRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        List<ItemStack> output = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            output.add(buffer.readItemStack());
        }
        Ingredient input = Ingredient.read(buffer);
        return new ChemicalCentrifugeRecipe(recipeId, input, output);
    }

    @Override
    public void write(PacketBuffer buffer, ChemicalCentrifugeRecipe recipe) {
        Ingredient input = recipe.getIngredients().get(0);
        input.write(buffer);
        for (int i = 0; i < 2; i++) {
            buffer.writeItemStack(recipe.getAllOutput().get(i), false);
        }
    }

}
