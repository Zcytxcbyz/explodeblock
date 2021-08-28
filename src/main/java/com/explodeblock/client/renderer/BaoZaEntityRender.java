package com.explodeblock.client.renderer;

import com.explodeblock.client.model.BaoZaEntityModel;
import com.explodeblock.entity.BaoZaEntity;
import com.explodeblock.util.Utils;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class BaoZaEntityRender extends BipedRenderer<BaoZaEntity, BaoZaEntityModel<BaoZaEntity>> {
    private static final ResourceLocation BAOZA_TEXTURES = new ResourceLocation(Utils.MOD_ID,"textures/entity/BaoZa.png");

    public BaoZaEntityRender(EntityRendererManager manager) {
            super(manager, new BaoZaEntityModel(0.0F, false), 0.5F);
            this.addLayer(new BipedArmorLayer(this, new BaoZaEntityModel(0.5F, true), new BaoZaEntityModel(1.0F, true)));
    }

    public ResourceLocation getEntityTexture(BaoZaEntity entity) {
        return BAOZA_TEXTURES;
    }

    protected boolean func_230495_a_(BaoZaEntity p_230495_1_) {
        return false;
    }
}
