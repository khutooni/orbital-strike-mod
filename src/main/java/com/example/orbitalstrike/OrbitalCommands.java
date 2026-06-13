package com.example.orbitalstrike;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.item.ItemStack;

public class OrbitalCommands {
    public static void registerCommands() {
        CommandDispatcher<ServerCommandSource> dispatcher = CommandManager.DISPATCHER;

        dispatcher.register(CommandManager.literal("orbital_nuke")
            .executes(ctx -> {
                ItemStack stack = new ItemStack(OrbitalItems.NUKE_SHOT);
                ctx.getSource().getPlayer().giveItemStack(stack);
                return 1;
            }));

        dispatcher.register(CommandManager.literal("orbital_stab")
            .executes(ctx -> {
                ItemStack stack = new ItemStack(OrbitalItems.STAB_SHOT);
                ctx.getSource().getPlayer().giveItemStack(stack);
                return 1;
            }));
    }
}
