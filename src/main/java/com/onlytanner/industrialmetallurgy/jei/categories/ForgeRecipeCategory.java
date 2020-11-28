package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.BasicForgeScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipeBase;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

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
        return "Forging";
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
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(forgeRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, forgeRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ForgeRecipe forgeRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 46, 21);
        guiItemStackGroup.init(1, true, 72, 21);
        guiItemStackGroup.init(2, true, 46, 47);
        guiItemStackGroup.init(3, true, 72, 47);
        guiItemStackGroup.init(4, false, 126, 34);
        for (int i = 0; i < iIngredients.getInputs(VanillaTypes.ITEM).size(); i++) {
            guiItemStackGroup.set(i, iIngredients.getInputs(VanillaTypes.ITEM).get(i));
        }
        guiItemStackGroup.set(4, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}