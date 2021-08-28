package com.explodeblock;

import com.explodeblock.block.BlockRegistry;
import com.explodeblock.config.CommonConfig;
import com.explodeblock.entity.EntityRegistry;
import com.explodeblock.item.ItemRegistry;
import com.explodeblock.tileentity.TileEntityRegistry;
import com.explodeblock.util.Utils;
import com.explodeblock.world.gen.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Utils.MOD_ID)
public class ExplodeBlock {

    public ExplodeBlock() {
        IEventBus ModEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(ModEventBus);
        ItemRegistry.ITEMS.register(ModEventBus);
        EntityRegistry.ENTITIES.register(ModEventBus);
        TileEntityRegistry.TILE_ENTITIES.register(ModEventBus);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::OresGenerate);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);
    }
}
