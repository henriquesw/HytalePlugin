package com.hwtechnology.exampleplugin;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import javax.annotation.Nonnull;

/**
 * This is an example command that will simply print the name of the plugin in chat when used.
 */
public class MainCommand extends CommandBase {

    public MainCommand(String pluginName, String pluginVersion) {
        super("test", "Prints a help message from the " + pluginName + " plugin.");
        this.addSubCommand(new VersionCommand(pluginName,pluginVersion));
        this.setPermissionGroup(GameMode.Adventure); // Allows the command to be used by anyone, not just OP
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        String message = """
                Usage (Append --help to any subcommand!)
                /test
                  version""";
        ctx.sendMessage(Message.raw(message));
    }
}