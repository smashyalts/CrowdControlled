package net.craftsupport.crowdcontrolled.command.subcmds;


import dev.jorel.commandapi.CommandAPICommand;
import net.craftsupport.crowdcontrolled.config.Messages;
import net.craftsupport.crowdcontrolled.util.TextUtility;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand {
    public static CommandAPICommand get(JavaPlugin plugin) {
        return new CommandAPICommand("reload")
                .withPermission("crowdcontrolled.command.reload")
                .executes(((commandSender, commandArguments) -> {
                    commandSender.sendMessage(TextUtility.color(Messages.SERVER_NAME.get() + " " + Messages.RELOADED.get()));
                }));
    }
}
