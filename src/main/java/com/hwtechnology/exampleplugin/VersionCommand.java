package com.hwtechnology.exampleplugin;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import javax.annotation.Nonnull;

/**
 * This is an example command that will simply print the name of the plugin in chat when used.
 */
public class VersionCommand extends CommandBase {
    private final String pluginName;
    private final String pluginVersion;

    public VersionCommand(String pluginName, String pluginVersion) {
        super("version", "Prints plugin " + pluginName + " version.");
        this.setPermissionGroup(GameMode.Adventure); // Allows the command to be used by anyone, not just OP
        this.pluginName = pluginName;
        this.pluginVersion = pluginVersion;
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        ctx.sendMessage(Message.raw(pluginName + " version: " + pluginVersion));
    }
}