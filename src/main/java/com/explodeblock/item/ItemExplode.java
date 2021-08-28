package com.explodeblock.item;

import com.explodeblock.block.BlockRegistry;
import com.explodeblock.group.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemExplode extends BlockItem {
    public ItemExplode() {
        super(BlockRegistry.explode_block.get(), new Item.Properties().group(ModGroup.itemGroup));
    }
}
