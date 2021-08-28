package com.explodeblock.tileentity;

import com.explodeblock.block.BlockRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class BlockExplodeTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 100;
    private int timer = 0;

    public static TileEntityType<BlockExplodeTileEntity> TYPE =  TileEntityType.Builder.create(BlockExplodeTileEntity::new, BlockRegistry.explode_block.get()).build(null);
    public BlockExplodeTileEntity() {
        super(TYPE);
    }

    @Override
    public void tick() {
        if (world != null && !world.isRemote){
            if (timer == MAX_TIME) {
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                if (player != null) {
                    player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, MAX_TIME, 3));
                }
                timer = 0;
            }
            timer++;
        }
    }
}
