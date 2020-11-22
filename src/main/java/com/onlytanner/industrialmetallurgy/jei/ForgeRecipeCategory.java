package com.onlytanner.industrialmetallurgy.jei;

import com.onlytanner.industrialmetallurgy.client.gui.BasicForgeScreen;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipeBase;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ForgeRecipeCategory implements IRecipeCategory<ForgeRecipe> {

    @Override
    public ResourceLocation getUid() {
        return ForgeRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends ForgeRecipe> getRecipeClass() {
        return ForgeRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Forge";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(BasicForgeScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.FORGE_TIER1_ITEM.get()));
    }

    @Override
    public void setIngredients(ForgeRecipe forgeRecipe, IIngredients iIngredients) {

    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ForgeRecipe forgeRecipe, IIngredients iIngredients) {

    }

}