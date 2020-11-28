package com.onlytanner.industrialmetallurgy.jei;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.client.gui.AdvancedForgeScreen;
import com.onlytanner.industrialmetallurgy.client.gui.BasicForgeScreen;
import com.onlytanner.industrialmetallurgy.jei.categories.*;
import com.onlytanner.industrialmetallurgy.recipes.ChemicalCentrifugeRecipe;
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
    private CrusherRecipeCategory crusherRecipeCategory;
    private CokeOvenRecipeCategory cokeOvenRecipeCategory;
    private ChemicalCentrifugeRecipeCategory chemicalCentrifugeRecipeCategory;
    private ChemicalReactorRecipeCategory chemicalReactorRecipeCategory;
    private ExtruderRecipeCategory extruderRecipeCategory;
    private SolderingStationRecipeCategory solderingStationRecipeCategory;

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(IndustrialMetallurgy.MOD_ID, "default");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        forgeRecipeCategory = new ForgeRecipeCategory();
        registration.addRecipeCategories(forgeRecipeCategory);
        crusherRecipeCategory = new CrusherRecipeCategory();
        registration.addRecipeCategories(crusherRecipeCategory);
        cokeOvenRecipeCategory = new CokeOvenRecipeCategory();
        registration.addRecipeCategories(cokeOvenRecipeCategory);
        chemicalCentrifugeRecipeCategory = new ChemicalCentrifugeRecipeCategory();
        registration.addRecipeCategories(chemicalCentrifugeRecipeCategory);
        chemicalReactorRecipeCategory = new ChemicalReactorRecipeCategory();
        registration.addRecipeCategories(chemicalReactorRecipeCategory);
        extruderRecipeCategory = new ExtruderRecipeCategory();
        registration.addRecipeCategories(extruderRecipeCategory);
        solderingStationRecipeCategory = new SolderingStationRecipeCategory();
        registration.addRecipeCategories(solderingStationRecipeCategory);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.FORGE_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), forgeRecipeCategory.getUid());
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.CRUSHER_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), crusherRecipeCategory.getUid());
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.COKE_OVEN_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), cokeOvenRecipeCategory.getUid());
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.CHEMICAL_CENTRIFUGE_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), chemicalCentrifugeRecipeCategory.getUid());
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.CHEMICAL_REACTOR_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), chemicalReactorRecipeCategory.getUid());
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.EXTRUDER_RECIPE_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), extruderRecipeCategory.getUid());
        registration.addRecipes(Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == RecipeSerializerInit.SOLDERING_STATION_RECIPE_TYPE).collect(Collectors.toSet()) : Collections.emptySet(), solderingStationRecipeCategory.getUid());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER1_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER2_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER3_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.FORGE_TIER4_ITEM.get()), forgeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.CRUSHER_ITEM.get()), crusherRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.COKE_OVEN_ITEM.get()), cokeOvenRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.CHEMICAL_CENTRIFUGE_ITEM.get()), chemicalCentrifugeRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.CHEMICAL_REACTOR_ITEM.get()), chemicalReactorRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.EXTRUDER_ITEM.get()), extruderRecipeCategory.getUid());
        registration.addRecipeCatalyst(new ItemStack(RegistryHandler.SOLDERING_STATION_ITEM.get()), solderingStationRecipeCategory.getUid());
    }

}
