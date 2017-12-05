package com.onlytanner.test.items.crafting;

import com.google.common.collect.Maps;
import com.onlytanner.test.init.ModItems;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CokeOvenRecipes {

    private static final CokeOvenRecipes COKE_OVEN_BASE = new CokeOvenRecipes();
    private final Map<ItemStack, ItemStack> list = Maps.<ItemStack, ItemStack>newHashMap();

    /**
     * Returns an instance of CrusherRecipes.
     */
    public static CokeOvenRecipes instance() {
        return COKE_OVEN_BASE;
    }

    private CokeOvenRecipes() {
        this.addSmeltingRecipe(new ItemStack(Items.COAL), new ItemStack(ModItems.coal_coke, 1));
    }

    /**
     * Adds a crushing recipe using an ItemStack as the input for the recipe.
     */
    public void addSmeltingRecipe(ItemStack input, ItemStack stack) {
        if (getSmeltingResult(input) != null) {
            net.minecraftforge.fml.common.FMLLog.info("Ignored smelting recipe with conflicting input: " + input + " = " + stack);
            return;
        }
        this.list.put(input, stack);
    }

    /**
     * Returns the crushing result of an item.
     */
    @Nullable
    public ItemStack getSmeltingResult(ItemStack stack) {
        for (Entry<ItemStack, ItemStack> entry : this.list.entrySet()) {
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

    public Map<ItemStack, ItemStack> getSmeltingList() {
        return this.list;
    }
}
