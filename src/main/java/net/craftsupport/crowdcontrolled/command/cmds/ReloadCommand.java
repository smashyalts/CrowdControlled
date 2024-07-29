package net.craftsupport.crowdcontrolled.command.cmds;

import net.craftsupport.crowdcontrolled.command.Command;
import net.craftsupport.crowdcontrolled.command.PermissionsHandler;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends Command {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reload the plugin's configs.";
    }

    @Override
    public String getSyntax() {
        return "/crowdcontrolled reload";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!PermissionsHandler.hasPerm(sender, permission(), true)) return;


    }

    @Override
    public String permission() {
        return "chatcontrolled.command.reload";
    }

    @Override
    public boolean allowConsole() {
        return true;
    }
}
