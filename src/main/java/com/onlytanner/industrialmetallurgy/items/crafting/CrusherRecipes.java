package com.onlytanner.industrialmetallurgy.items.crafting;

import com.google.common.collect.Maps;
import com.onlytanner.industrialmetallurgy.init.ModBlocks;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CrusherRecipes {

    private static final CrusherRecipes CRUSHING_BASE = new CrusherRecipes();
    private final Map<ItemStack, ItemStack> crushingList = Maps.<ItemStack, ItemStack>newHashMap();

    /**
     * Returns an instance of CrusherRecipes.
     */
    public static CrusherRecipes instance() {
        return CRUSHING_BASE;
    }

    private CrusherRecipes() {
        this.addCrushingRecipe(new ItemStack(ModBlocks.bauxite_ore), new ItemStack(ModItems.crushed_bauxite_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.cassiterite_ore), new ItemStack(ModItems.crushed_cassiterite_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.chromite_ore), new ItemStack(ModItems.crushed_chromite_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.cobaltite_ore), new ItemStack(ModItems.crushed_cobaltite_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.cuprite_ore), new ItemStack(ModItems.crushed_cuprite_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.garnierite_ore), new ItemStack(ModItems.crushed_garnierite_ore, 2));
        this.addCrushingRecipe(new ItemStack(Blocks.GOLD_ORE), new ItemStack(ModItems.crushed_gold_ore, 2));
        this.addCrushingRecipe(new ItemStack(Blocks.IRON_ORE), new ItemStack(ModItems.crushed_iron_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.rutile_ore), new ItemStack(ModItems.crushed_rutile_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.sphalerite_ore), new ItemStack(ModItems.crushed_sphalerite_ore, 2));
        this.addCrushingRecipe(new ItemStack(ModBlocks.wolframite_ore), new ItemStack(ModItems.crushed_wolframite_ore, 2));
        this.addCrushingRecipe(new ItemStack(Items.COAL), new ItemStack(ModItems.crushed_coal));
        this.addCrushingRecipe(new ItemStack(Items.DIAMOND), new ItemStack(ModItems.crushed_diamond));
        this.addCrushingRecipe(new ItemStack(Blocks.COAL_ORE), new ItemStack(Items.COAL, 2));
        this.addCrushingRecipe(new ItemStack(Blocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE, 10));
        this.addCrushingRecipe(new ItemStack(Blocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND, 2));
        this.addCrushingRecipe(new ItemStack(Blocks.LAPIS_ORE), new ItemStack(Items.DYE, 16, 4));
        this.addCrushingRecipe(new ItemStack(Blocks.EMERALD_ORE), new ItemStack(Items.EMERALD, 2));
        this.addCrushingRecipe(new ItemStack(Blocks.STONE), new ItemStack(Blocks.COBBLESTONE));
        this.addCrushingRecipe(new ItemStack(Blocks.COBBLESTONE), new ItemStack(Blocks.GRAVEL));
        this.addCrushingRecipe(new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.SAND));
        this.addCrushingRecipe(new ItemStack(Items.BONE), new ItemStack(Items.DYE, 6, 15));
        this.addCrushingRecipe(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER, 4));
    }

    /**
     * Adds a crushing recipe using an ItemStack as the input for the recipe.
     */
    public void addCrushingRecipe(ItemStack input, ItemStack stack) {
        if (getCrushingResult(input) != null) {
            net.minecraftforge.fml.common.FMLLog.info("Ignored crushing recipe with conflicting input: " + input + " = " + stack);
            return;
        }
        this.crushingList.put(input, stack);
    }

    /**
     * Returns the crushing result of an item.
     */
    @Nullable
    public ItemStack getCrushingResult(ItemStack stack) {
        for (Entry<ItemStack, ItemStack> entry : this.crushingList.entrySet()) {
            if (this.compareItemStacks(stack, (ItemStack) entry.getKey())) {
                return (ItemStack) entry.getValue();
            }
        }

        return null;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks
     * both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCrushingList() {
        return this.crushingList;
    }
}
