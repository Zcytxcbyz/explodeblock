package com.explodeblock.client.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.entity.monster.MonsterEntity;

public class BaoZaEntityModel<T extends MonsterEntity> extends BipedModel<T> {
    public boolean isAggressive(T entity) {
        return entity.isAggressive();
    }

    public BaoZaEntityModel(float p_i1168_1_, boolean p_i1168_2_) {
        super(p_i1168_1_, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, this.isAggressive(entity), this.swingProgress, ageInTicks);
    }
}
