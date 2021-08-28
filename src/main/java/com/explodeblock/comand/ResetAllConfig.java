package com.explodeblock.comand;

import com.explodeblock.config.block.BlockExplodeConfig;
import com.explodeblock.config.world.gen.OreExplodeConfig;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.StringTextComponent;

public class ResetAllConfig implements Command<CommandSource> {
    @Override
    public int run(CommandContext<CommandSource> context) {
        OreExplodeConfig.reset();
        BlockExplodeConfig.reset();
        context.getSource().sendFeedback(new StringTextComponent("Reset Config Success"), false);
        return 0;
    }
}
