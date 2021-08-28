package com.explodeblock.entity;

import com.explodeblock.util.Utils;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BaoZaEntity extends MonsterEntity {
    protected BaoZaEntity(EntityType<? extends MonsterEntity> entityType, World world) {
        super(entityType, world);
    }

    public static EntityType<BaoZaEntity> TYPE = EntityType.Builder.create(BaoZaEntity::new, EntityClassification.MONSTER)
            .size(0.6F, 1.95F)
            .trackingRange(8)
            .build(new ResourceLocation(Utils.MOD_ID,"baoza").toString());

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0D)
                .createMutableAttribute(Attributes.ARMOR, 2.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 10f));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 10;
    }
}
