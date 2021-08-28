package com.explodeblock.item;

import com.explodeblock.group.ModGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ExplodeCore extends Item {
    private static final Food food = new Food.Builder()
            .saturation(0.8F)
            .hunger(1)
            .effect(() -> new EffectInstance(Effects.POISON,6000,3),1)
            .effect(() -> new EffectInstance(Effects.NAUSEA,6000,3),1)
            .effect(() -> new EffectInstance(Effects.HUNGER,6000,3),1)
            .effect(() -> new EffectInstance(Effects.WEAKNESS,6000,3),1)
            .effect(() -> new EffectInstance(Effects.SLOWNESS,6000,3),1)
            .effect(() -> new EffectInstance(Effects.MINING_FATIGUE,6000,3),1)
            .build();
    public ExplodeCore() {
        super(new Item.Properties().food(food).group(ModGroup.itemGroup));
    }
}
