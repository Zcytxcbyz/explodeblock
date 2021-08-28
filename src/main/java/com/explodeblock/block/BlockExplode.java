package com.explodeblock.block;

import com.explodeblock.config.block.BlockExplodeConfig;
//import com.explodeblock.tileentity.BlockExplodeTileEntity;
import com.explodeblock.tileentity.BlockExplodeTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockExplode extends Block {
    public BlockExplode() {
        super(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                .harvestTool(ToolType.PICKAXE)
                .hardnessAndResistance(1.5F,6)
                .harvestLevel(0)
                .setRequiresTool()
                .sound(SoundType.STONE));
    }

    /*
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BlockExplodeTileEntity();
    }
    */

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity entity) {
        explode(world, pos);
        super.onBlockHarvested(world, pos, state, entity);
    }

    @Override
    public void onExplosionDestroy(World world, BlockPos pos, Explosion entity) {
        explode(world, pos);
        super.onExplosionDestroy(world, pos, entity);
    }

    @Override
    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos);
        super.catchFire(state, world, pos, face, igniter);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos blockPos, PlayerEntity entity, Hand hand, BlockRayTraceResult result) {
        ItemStack itemstack = entity.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
            return super.onBlockActivated(state, world, blockPos, entity, hand, result);
        } else {
            this.catchFire(state, world, blockPos, result.getFace(), entity);
            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 11);
            if (!entity.isCreative()) {
                if (item == Items.FLINT_AND_STEEL) {
                    itemstack.damageItem(1, entity, (player) -> {
                        player.sendBreakAnimation(hand);
                    });
                } else {
                    itemstack.shrink(1);
                }
            }

            return ActionResultType.func_233537_a_(world.isRemote);
        }
    }

    private static void explode(World world, BlockPos pos) {
        if (!world.isRemote) {
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), BlockExplodeConfig.ExplosionRange.get().floatValue(), Explosion.Mode.BREAK);
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }
}
