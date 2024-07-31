package net.craftsupport.crowdcontrolled.command;

import net.craftsupport.crowdcontrolled.command.cmds.DebugCommand;
import net.craftsupport.crowdcontrolled.command.cmds.ReloadCommand;
import net.craftsupport.crowdcontrolled.config.Messages;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandHandler implements CommandExecutor {

    private static ArrayList<Command> subcommands = new ArrayList<>();

    public CommandHandler() {
        subcommands.add(new ReloadCommand());
        subcommands.add(new DebugCommand());
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull org.bukkit.command.Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length > 0) {
            for (Command subcommand : subcommands) {
                if (strings[0].equals(subcommand.getName())) {
                    if (!strings[0].equals(subcommand.allowConsole()) && commandSender instanceof Player) {
                        subcommand.execute(commandSender, strings);
                    } else {
                        Messages.COMMAND_PLAYER_ONLY.send(commandSender);
                    }
                }
            }
        }

        return true;
    }
}
