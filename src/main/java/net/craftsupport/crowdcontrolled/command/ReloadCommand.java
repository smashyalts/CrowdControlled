package net.craftsupport.crowdcontrolled.command;


import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand {
    public static void register(JavaPlugin plugin) {
        new CommandAPICommand("crowdcontrolled reload")
                .withPermission("crowdcontrolled.command.reload")
                .executes(((commandSender, commandArguments) -> {
                    // code goes in here
                }))
                .register();
    }
}
