package net.craftsupport.crowdcontrolled.command.subcmds;


import com.sun.security.auth.login.ConfigFile;
import dev.jorel.commandapi.CommandAPICommand;
import net.craftsupport.crowdcontrolled.CrowdControlled;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import net.craftsupport.crowdcontrolled.config.ConfigHandler;
import net.craftsupport.crowdcontrolled.config.Messages;
import net.craftsupport.crowdcontrolled.util.TextUtility;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand {
    public static CommandAPICommand get(JavaPlugin plugin) {
        return new CommandAPICommand("reload")
                .withPermission("crowdcontrolled.command.reload")
                .executes(((commandSender, commandArguments) -> {
                    ConfigFileHandler cfg = new ConfigFileHandler();

                    cfg.loadFiles(CrowdControlled.getInstance());

                    commandSender.sendMessage(TextUtility.color(Messages.SERVER_NAME.get() + " " + Messages.RELOADED.get()));
                }));
    }
}
