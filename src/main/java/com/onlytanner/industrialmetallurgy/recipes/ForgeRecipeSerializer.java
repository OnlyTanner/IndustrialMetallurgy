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

public class ForgeRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ForgeRecipe> {

    @Override
    public ForgeRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), true);
        Ingredient input = Ingredient.deserialize(JSONUtils.getJsonArray(json, "input"));
        for (int i = 0; i < input.getMatchingStacks().length; i++) {
            System.out.println(input.getMatchingStacks()[i].getItem() + ": " + input.getMatchingStacks()[i].getCount());
        }
        System.out.println();
        return new ForgeRecipe(recipeId, input, output);
    }

    @Nullable
    @Override
    public ForgeRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        Ingredient input = Ingredient.read(buffer);
        return new ForgeRecipe(recipeId, input, output);
    }

    @Override
    public void write(PacketBuffer buffer, ForgeRecipe recipe) {
        Ingredient input = recipe.getIngredients().get(0);
        input.write(buffer);
        buffer.writeItemStack(recipe.getRecipeOutput(), false);
    }

}
