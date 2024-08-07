package net.craftsupport.crowdcontrolled.command;

import dev.jorel.commandapi.CommandAPICommand;
import net.craftsupport.crowdcontrolled.command.subcmds.DebugCommand;
import net.craftsupport.crowdcontrolled.command.subcmds.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CrowdcontrolledCommand {
    public static void register(JavaPlugin plugin) {
        new CommandAPICommand("crowdcontrolled")
                .withSubcommand(DebugCommand.get(plugin))
                .withSubcommand(ReloadCommand.get(plugin))
                .withPermission("crowdcontrolled.command.crowdcontrolled")
                .register();
    }
}
