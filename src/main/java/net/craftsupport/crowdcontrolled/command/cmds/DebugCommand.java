package net.craftsupport.crowdcontrolled.command.cmds;

import net.craftsupport.crowdcontrolled.command.Command;
import net.craftsupport.crowdcontrolled.command.PermissionsHandler;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import net.craftsupport.crowdcontrolled.config.ConfigTypes;
import net.craftsupport.crowdcontrolled.config.Messages;
import net.craftsupport.crowdcontrolled.util.ColorAPI;
import org.bukkit.command.CommandSender;

import java.awt.*;

public class DebugCommand extends Command {
    @Override
    public String getName() {
        return "debug";
    }

    @Override
    public String getDescription() {
        return "Executes a specific function of the plugin to test its functionality.";
    }

    @Override
    public String getSyntax() {
        return "/crowdcontrolled debug <function to debug>";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!PermissionsHandler.hasPerm(sender, permission(), true)) return;

        switch (args[0]) {
            case "testcolors": // just as an example, other commands will be added once new features are going to get tested
                sender.sendMessage(Messages.SERVER_NAME.get() + ColorAPI.color(" This function tests out the color parsing of the plugin.", Color.PINK, Color.BLUE));

            case "other_case":
                sender.sendMessage(Messages.SERVER_NAME.get() + ColorAPI.color(" This is another switch case.", Color.PINK, Color.BLUE));

            case "getEventConfig":
                sender.sendMessage(ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().saveToString());
        }
    }

    @Override
    public String permission() {
        return "crowdcontrolled.command.debug";
    }

    @Override
    public boolean allowConsole() { return true; }
}
