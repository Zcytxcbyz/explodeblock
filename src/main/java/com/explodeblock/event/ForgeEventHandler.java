package com.explodeblock.event;

import com.explodeblock.comand.ResetAllConfig;
import com.explodeblock.util.Utils;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    @SubscribeEvent
    public static void onServerStaring(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal(Utils.MOD_ID)
                .then(Commands.literal("ResetAllConfig")
                        .requires((commandSource) -> commandSource.hasPermissionLevel(0))
                        .executes(new ResetAllConfig())));
    }
}
