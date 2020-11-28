package com.onlytanner.industrialmetallurgy.jei;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.client.gui.AdvancedForgeScreen;
import com.onlytanner.industrialmetallurgy.client.gui.BasicForgeScreen;
import com.onlytanner.industrialmetallurgy.jei.categories.ForgeRecipeCategory;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.RecipeSerializerInit;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.handlers.IGhostIngredientHandler;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Rectangle2d;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class ModJEI implements IModPlugin {

    private ForgeRecipeCategory forgeRecipeCategory;

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(IndustrialMetallurgy.MOD_ID, "default");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        forgeRecipeCategory = new ForgeRecipeCategory();
        registration.addRecipeCategories(forgeRecipeCategory);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.FORGE_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), forgeRecipeCategory.getUid());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER1_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER2_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER3_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER4_ITEM.get()), forgeRecipeCategory.getUid());
    }

}
