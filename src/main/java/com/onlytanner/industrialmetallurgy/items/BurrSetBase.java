package com.onlytanner.industrialmetallurgy.items;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BurrSetBase extends Item implements IVanishable {

    private static final int MAX_DAMAGE = 480;

    public BurrSetBase() {
        super(new Item.Properties().group(IndustrialMetallurgy.TAB).defaultMaxDamage(MAX_DAMAGE));
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return (stack.getDamage() > 0);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        if (stack.getDamage() == MAX_DAMAGE - 1)
            stack.setCount(0);
        else
            super.setDamage(stack, damage);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

}
