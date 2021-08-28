package com.explodeblock.item;

import com.explodeblock.entity.BaoZaEntity;
import com.explodeblock.group.ModGroup;
import com.explodeblock.util.Utils;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<ItemExplode> explode_block = ITEMS.register("explode_block", ItemExplode::new);
    public static final RegistryObject<ExplodeCore> explode_core = ITEMS.register("explode_core", ExplodeCore::new);
    //public static final RegistryObject<SpawnEggItem> baoza_spawn_egg = ITEMS.register("baoza_spawn_egg", () -> new SpawnEggItem(BaoZaEntity.TYPE, 0x000000, 0x323232, new Item.Properties().group(ModGroup.itemGroup)));
}
