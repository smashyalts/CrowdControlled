package net.craftsupport.crowdcontrolled.command.subcmds;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import net.craftsupport.crowdcontrolled.config.ConfigTypes;
import net.craftsupport.crowdcontrolled.config.Messages;
import net.craftsupport.crowdcontrolled.event.EventHandler;
import net.craftsupport.crowdcontrolled.util.ColorAPI;
import net.craftsupport.crowdcontrolled.util.TextUtility;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DebugCommand {

    public static CommandAPICommand get(JavaPlugin plugin) {
        return new CommandAPICommand("debug")
                .withAliases("debug")
                .withArguments(new StringArgument("mode"))
                .withPermission("crowdcontrolled.command.debug")
                .withSubcommand(
                        new CommandAPICommand("testcolors")
                                .executes(((commandSender, commandArguments) -> {
//                                    commandSender.sendMessage("This feature currently doesn't work as intended. Please contact the developers uwu");
                                    commandSender.sendMessage(TextUtility.color(Messages.SERVER_NAME.get() + "{#3236A8} This function tests out the color parsing of the plugin. {/#DB18BE} {#2AD1CE} Here's another cool gradient :D {/#85E610}\n&fThis is the color white.\n&9This is the color blue.\n&6This is the color gold.\n&4And this is dark red."));
                                }))
                )
                .withSubcommand(
                        new CommandAPICommand("getEventConfig")
                                .executes(((commandSender, commandArguments) -> {
                                    commandSender.sendMessage(ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().get("Events").toString());
                                }))
                )
                .withSubcommand(
                        new CommandAPICommand("getSpecificEventConfig")
                                .withArguments(new StringArgument("cfg"))
                                .executes(((commandSender, commandArguments) -> {
                                    commandSender.sendMessage(ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().get((String) commandArguments.get("cfg")).toString());
                                }))
                )
                .withSubcommand(
                        new CommandAPICommand("testEvent")
                                .withArguments(new StringArgument("type"))
                                .executes(((commandSender, commandArguments) -> {
                                    EventHandler.execute(commandArguments.get("type").toString(), (LinkedHashMap) ((LinkedHashMap) ((LinkedHashMap) ((ArrayList<Object>) ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().get("Events")).get(0)).get("addSize")).get("values") );
                                }))
                )
                .withSubcommand(
                        new CommandAPICommand("cfg")
                                .executes(((commandSender, commandArguments) -> {
                                    ArrayList<Object> list = (ArrayList<Object>) ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().get("Events");

                                    LinkedHashMap list2 = (LinkedHashMap) list.get(0);

                                    Object l3 = list2.get("addSize");

                                    commandSender.sendMessage(list2.getClass().toString());
                                    commandSender.sendMessage(list2.toString());

                                    commandSender.sendMessage(l3.toString());
                                }))
                );
    }
}
