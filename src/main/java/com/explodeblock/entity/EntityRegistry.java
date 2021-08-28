package com.explodeblock.entity;

import com.explodeblock.util.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);
    //public static final RegistryObject<EntityType<BaoZaEntity>> baoza = ENTITIES.register("baoza",  () -> BaoZaEntity.TYPE);

    public static void SetEntityTypeAttributes() {
        //GlobalEntityTypeAttributes.put(baoza.get(), BaoZaEntity.setAttributes().create());
    }

}
