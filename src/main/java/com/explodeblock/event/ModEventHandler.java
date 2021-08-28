package com.explodeblock.event;

import com.explodeblock.entity.EntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent<Block> event){

    }
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent<Item> event){

    }

    @SubscribeEvent
    public static  void onCommonSetup(final FMLCommonSetupEvent event) {
        //DeferredWorkQueue.runLater(EntityRegistry::SetEntityTypeAttributes);
    }
}
