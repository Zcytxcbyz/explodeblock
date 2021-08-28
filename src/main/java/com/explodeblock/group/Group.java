package com.explodeblock.group;

import com.explodeblock.item.ItemRegistry;
import com.explodeblock.util.Utils;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;

public class Group extends ItemGroup {
    public Group() {
        super(new TranslationTextComponent(String.format("%s.ModName", Utils.MOD_ID)).getString());
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.explode_block.get());
    }
}
