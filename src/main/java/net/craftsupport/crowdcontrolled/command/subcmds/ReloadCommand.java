package net.craftsupport.crowdcontrolled.command.subcmds;


import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand {
    public static CommandAPICommand get(JavaPlugin plugin) {
        return new CommandAPICommand("reload")
                .withPermission("crowdcontrolled.command.reload")
                .executes(((commandSender, commandArguments) -> {
                    // code goes in here
                }));
    }
}
