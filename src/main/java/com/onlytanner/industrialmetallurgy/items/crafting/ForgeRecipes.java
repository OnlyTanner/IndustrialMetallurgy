package com.onlytanner.industrialmetallurgy.items.crafting;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForgeRecipes
{
    private static ArrayList<AlloyRecipe> smeltingList = new ArrayList<AlloyRecipe>();
    private static final ForgeRecipes FORGE_RECIPES = new ForgeRecipes();

    private ForgeRecipes()
    {
        this.addAlloyRecipe(new ItemStack(ModItems.copper_ingot, 2), new ItemStack(ModItems.zinc_ingot), new ItemStack(ModItems.brass_ingot, 3), 1.05F, 1700);
        this.addAlloyRecipe(new ItemStack(ModItems.copper_ingot, 3), new ItemStack(ModItems.tin_ingot), new ItemStack(ModItems.bronze_ingot, 4), 1.4F, 1900);
        this.addAlloyRecipe(new ItemStack(Items.IRON_INGOT, 2), new ItemStack(ModItems.nickel_ingot), new ItemStack(ModItems.invar_ingot, 3), 1.05F, 2600);
        this.addAlloyRecipe(new ItemStack(ModItems.nickel_ingot, 4), new ItemStack(ModItems.chromium_ingot), new ItemStack(ModItems.nichrome_ingot, 5), 1.75F, 2600);
        this.addAlloyRecipe(new ItemStack(ModItems.nickel_ingot), new ItemStack(ModItems.titanium_ingot), new ItemStack(ModItems.nitinol_ingot, 2), 0.7F, 2400);
        this.addAlloyRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.crushed_coal, 4), new ItemStack(ModItems.steel_ingot), 0.35F, 2700);
        this.addAlloyRecipe(new ItemStack(ModItems.cobalt_steel_ingot, 4), new ItemStack(ModItems.steel_ingot, 3), new ItemStack(ModItems.cobalt_ingot), 0.35F, 4700);
        
        this.addAlloyRecipe(new ItemStack(ModItems.tungsten_ingot, 2), new ItemStack(ModItems.cobalt_ingot), new ItemStack(ModItems.crushed_coal, 8), new ItemStack(ModItems.tungsten_carbide_dust, 2), 0.70F, 6000);
        this.addAlloyRecipe(new ItemStack(Items.IRON_INGOT, 5), new ItemStack(ModItems.chromium_ingot, 2), new ItemStack(ModItems.aluminum_ingot), new ItemStack(ModItems.kanthal_ingot, 8), 0.70F, 2730);
        this.addAlloyRecipe(new ItemStack(ModItems.cobalt_steel_ingot, 3), new ItemStack(ModItems.tungsten_carbide_dust, 2), new ItemStack(ModItems.titanium_ingot), new ItemStack(ModItems.tungsten_steel_ingot, 4), 0.70F, 7000);
        
        this.addAlloyRecipe(new ItemStack(ModItems.tungsten_steel_ingot, 4), new ItemStack(ModItems.crushed_diamond, 4), new ItemStack(Items.BLAZE_POWDER, 16), new ItemStack(Items.NETHER_STAR), new ItemStack(ModItems.alloy7201_ingot, 4), 0.70F, 7000);
    }

    public static ForgeRecipes getInstance()
    {
        return FORGE_RECIPES;
    }

    /**
     * Adds an alloy recipe using two ItemStacks as the input for the recipe.
     */
    public void addAlloyRecipe(ItemStack input1, ItemStack input2, ItemStack output, float experience, int temperature)
    {
        ArrayList<ItemStack> inputs = new ArrayList<ItemStack>();
        inputs.add(input1);
        inputs.add(input2);
        smeltingList.add(new AlloyRecipe(inputs, output, experience, temperature));
    }
    
    /**
     * Adds an alloy recipe using two ItemStacks as the input for the recipe.
     */
    public void addAlloyRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output, float experience, int temperature)
    {
        ArrayList<ItemStack> inputs = new ArrayList<ItemStack>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        smeltingList.add(new AlloyRecipe(inputs, output, experience, temperature));
    }
    
    /**
     * Adds an alloy recipe using two ItemStacks as the input for the recipe.
     */
    public void addAlloyRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack output, float experience, int temperature)
    {
        ArrayList<ItemStack> inputs = new ArrayList<ItemStack>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        inputs.add(input4);
        smeltingList.add(new AlloyRecipe(inputs, output, experience, temperature));
    }

    /**
     * Returns the alloy result of two items.
     */
    @Nullable
    public static ItemStack getAlloyResult(ArrayList<ItemStack> inputs)
    {
        for (AlloyRecipe instance : smeltingList) {
            if (isValidForSmelting(inputs, instance)) {
                return instance.getOutput();
            }
        }
        return null;
    }

    @Nullable
    public static ItemStack[] getReducedStacks(ItemStack input1, ItemStack input2)
    {
        ItemStack[] stack = new ItemStack[2];
        for (AlloyRecipe instance : smeltingList) {
            if (instance.getInputs().size() == 2) {
                if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                    input2.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(0);
                }
            }
        }
        return stack;
    }
    
    @Nullable
    public static ItemStack[] getReducedStacks(ItemStack input1, ItemStack input2, ItemStack input3)
    {
        ItemStack[] stack = new ItemStack[3];
        for (AlloyRecipe instance : smeltingList) {
            if (instance.getInputs().size() == 3) {
                if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                    input2.getItem() == instance.getInputs().get(1).getItem() && 
                    input3.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() &&
                           input3.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(0);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(1).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(0);
                }
            }
        }
        return stack;
    }
    
    @Nullable
    public static ItemStack[] getReducedStacks(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4)
    {
        ItemStack[] stack = new ItemStack[4];
        for (AlloyRecipe instance : smeltingList) {
            if (instance.getInputs().size() == 4) {
                if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                    input2.getItem() == instance.getInputs().get(1).getItem() && 
                    input3.getItem() == instance.getInputs().get(2).getItem() && 
                    input4.getItem() == instance.getInputs().get(3).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(2);
                    stack[3] = instance.getInputs().get(3);
                } else if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                           input2.getItem() == instance.getInputs().get(1).getItem() && 
                           input3.getItem() == instance.getInputs().get(3).getItem() && 
                           input4.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(3);
                    stack[3] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem() && 
                           input4.getItem() == instance.getInputs().get(3).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(1);
                    stack[3] = instance.getInputs().get(3);
                } else if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(3).getItem() && 
                           input4.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(3);
                    stack[3] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                           input2.getItem() == instance.getInputs().get(3).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem() && 
                           input4.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(3);
                    stack[2] = instance.getInputs().get(1);
                    stack[3] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(0).getItem() && 
                           input2.getItem() == instance.getInputs().get(3).getItem() && 
                           input3.getItem() == instance.getInputs().get(2).getItem() && 
                           input4.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(0);
                    stack[1] = instance.getInputs().get(3);
                    stack[2] = instance.getInputs().get(2);
                    stack[3] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(2).getItem() && 
                           input4.getItem() == instance.getInputs().get(3).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(2);
                    stack[3] = instance.getInputs().get(3);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(3).getItem() && 
                           input4.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(3);
                    stack[3] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem() && 
                           input4.getItem() == instance.getInputs().get(3).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(0);
                    stack[3] = instance.getInputs().get(3);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(3).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem() && 
                           input4.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(3);
                    stack[2] = instance.getInputs().get(0);
                    stack[3] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(3).getItem() && 
                           input4.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(3);
                    stack[3] = instance.getInputs().get(0);
                } else if (input1.getItem() == instance.getInputs().get(1).getItem() && 
                           input2.getItem() == instance.getInputs().get(3).getItem() && 
                           input3.getItem() == instance.getInputs().get(2).getItem() && 
                           input4.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(1);
                    stack[1] = instance.getInputs().get(3);
                    stack[2] = instance.getInputs().get(2);
                    stack[3] = instance.getInputs().get(0);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem() && 
                           input4.getItem() == instance.getInputs().get(3).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(1);
                    stack[3] = instance.getInputs().get(3);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(3).getItem() && 
                           input4.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(3);
                    stack[3] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(3).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem() && 
                           input4.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(3);
                    stack[2] = instance.getInputs().get(0);
                    stack[3] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(3).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem() && 
                           input4.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(3);
                    stack[2] = instance.getInputs().get(1);
                    stack[3] = instance.getInputs().get(0);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(1).getItem() && 
                           input3.getItem() == instance.getInputs().get(3).getItem() && 
                           input4.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(3);
                    stack[3] = instance.getInputs().get(0);
                } else if (input1.getItem() == instance.getInputs().get(2).getItem() && 
                           input2.getItem() == instance.getInputs().get(1).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem() && 
                           input4.getItem() == instance.getInputs().get(3).getItem()) {
                    stack[0] = instance.getInputs().get(2);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(0);
                    stack[3] = instance.getInputs().get(3);
                } else if (input1.getItem() == instance.getInputs().get(3).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem() && 
                           input4.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(3);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(1);
                    stack[3] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(3).getItem() && 
                           input2.getItem() == instance.getInputs().get(0).getItem() && 
                           input3.getItem() == instance.getInputs().get(2).getItem() && 
                           input4.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(3);
                    stack[1] = instance.getInputs().get(0);
                    stack[2] = instance.getInputs().get(2);
                    stack[3] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(3).getItem() && 
                           input2.getItem() == instance.getInputs().get(1).getItem() && 
                           input3.getItem() == instance.getInputs().get(2).getItem() && 
                           input4.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(3);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(2);
                    stack[3] = instance.getInputs().get(0);
                } else if (input1.getItem() == instance.getInputs().get(3).getItem() && 
                           input2.getItem() == instance.getInputs().get(1).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem() && 
                           input4.getItem() == instance.getInputs().get(2).getItem()) {
                    stack[0] = instance.getInputs().get(3);
                    stack[1] = instance.getInputs().get(1);
                    stack[2] = instance.getInputs().get(0);
                    stack[3] = instance.getInputs().get(2);
                } else if (input1.getItem() == instance.getInputs().get(3).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(0).getItem() && 
                           input4.getItem() == instance.getInputs().get(1).getItem()) {
                    stack[0] = instance.getInputs().get(3);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(0);
                    stack[3] = instance.getInputs().get(1);
                } else if (input1.getItem() == instance.getInputs().get(3).getItem() && 
                           input2.getItem() == instance.getInputs().get(2).getItem() && 
                           input3.getItem() == instance.getInputs().get(1).getItem() && 
                           input4.getItem() == instance.getInputs().get(0).getItem()) {
                    stack[0] = instance.getInputs().get(3);
                    stack[1] = instance.getInputs().get(2);
                    stack[2] = instance.getInputs().get(1);
                    stack[3] = instance.getInputs().get(0);
                }
            }
        }
        return stack;
    }

    /**
     * Returns the AlloyRecipe array representation of all the currently stored
     * alloy recipes
     *
     * @return AlloyRecipe array of all the alloy recipes
     */
    public ArrayList<AlloyRecipe> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        for (AlloyRecipe instance : smeltingList) {
            if (stack.getItem() == instance.getOutput().getItem()) {
                return instance.getExperience();
            }
        }
        return 0.0F;
    }

    public static boolean isValidForSmelting(ArrayList<ItemStack> inputs, AlloyRecipe instance)
    {
        int count = inputs.size();
        if (count != instance.getInputs().size())
            return false;
        
        for (ItemStack recipe : instance.getInputs()) {
            for (ItemStack itemStack : inputs)
                if (itemStack != null && itemStack.getItem() == recipe.getItem())
                    count--;
            if (count == 0)
                return true;
        }
        return false;
    }

    public static boolean isPotentialInput(Item item)
    {
        for (AlloyRecipe recipe : smeltingList) {
            for (ItemStack itemStack : recipe.getInputs()) {
                if (itemStack.getItem() == item || itemStack.getItem() == item) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getTemperature(Item metal)
    {
        if (metal != null) {
            for (AlloyRecipe recipe : smeltingList) {
                if (metal == recipe.getOutput().getItem()) {
                    return recipe.getTemperature();
                }
            }
        }
        return 1000;
    }

    /**
     * Representation of an alloy recipe which contains two input items and an
     * output. It also specifies the amount of experienced gained from any
     * specific recipe.
     *
     * @author Tanner Lisonbee
     */
    public class AlloyRecipe
    {
        private ArrayList<ItemStack> inputs;
        private ItemStack output;
        private Float experience;
        private int temperature;

        protected AlloyRecipe(ArrayList<ItemStack> inputs, ItemStack output, Float experience, int temperature)
        {
            this.inputs = inputs;
            this.output = output;
            this.experience = experience;
            this.temperature = temperature;
        }

        protected ArrayList<ItemStack> getInputs()
        {
            return inputs;
        }

        protected ItemStack getOutput()
        {
            return output;
        }

        protected Float getExperience()
        {
            return experience;
        }

        protected int getTemperature()
        {
            return temperature;
        }
    }
}
