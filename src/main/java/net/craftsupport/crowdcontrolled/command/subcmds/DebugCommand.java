package net.craftsupport.crowdcontrolled.command.subcmds;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import net.craftsupport.crowdcontrolled.config.ConfigTypes;
import net.craftsupport.crowdcontrolled.config.Messages;
import net.craftsupport.crowdcontrolled.util.ColorAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public class DebugCommand {

    public static CommandAPICommand get(JavaPlugin plugin) {
        return new CommandAPICommand("debug")
                .withAliases("debug")
                .withArguments(new StringArgument("mode"))
                .withPermission("crowdcontrolled.command.debug")
                .withSubcommand(
                        new CommandAPICommand("testcolors")
                                .executes(((commandSender, commandArguments) -> {
                                    commandSender.sendMessage(Messages.SERVER_NAME.get() + ColorAPI.color(" This function tests out the color parsing of the plugin.", Color.PINK, Color.BLUE));
                                }))
                )
                .withSubcommand(
                        new CommandAPICommand("getEventConfig")
                                .executes(((commandSender, commandArguments) -> {
                                    commandSender.sendMessage(ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().saveToString());
                                }))
                );
    }
}
