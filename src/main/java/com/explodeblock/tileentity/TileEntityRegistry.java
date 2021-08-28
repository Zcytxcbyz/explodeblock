package com.explodeblock.tileentity;

import com.explodeblock.util.Utils;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);
    //public static final RegistryObject<TileEntityType<BlockExplodeTileEntity>> block_explode_tileentity = TILE_ENTITIES.register("block_explode_tileentity", () -> BlockExplodeTileEntity.TYPE);
}
