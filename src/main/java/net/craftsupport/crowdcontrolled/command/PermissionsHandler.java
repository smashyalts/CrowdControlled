package net.craftsupport.crowdcontrolled.command;

import net.craftsupport.crowdcontrolled.config.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class PermissionsHandler {
    public static boolean hasPerm(CommandSender sender, String node, boolean sendDeny) {
        if (sender instanceof ConsoleCommandSender) return true;

        Player player = (Player) sender;
        if (player.hasPermission(node)) return true;

        if (sendDeny) {
            Messages.PERMISSION_DENY.send(player);
        }
        return false;
    }
}
