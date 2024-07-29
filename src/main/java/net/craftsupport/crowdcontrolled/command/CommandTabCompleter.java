package net.craftsupport.crowdcontrolled.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CommandTabCompleter implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player) || args.length == 0 || !sender.hasPermission("chatcontrolled.island.help")) return null;

        if (args.length == 1) {
            String arg = args[0].toLowerCase(Locale.ROOT);
            List<String> completions = new ArrayList<>();

            if (sender.hasPermission("chatcontrolled.command.reload")) {
                completions.add("reload");
            }

            return StringUtil.copyPartialMatches(arg, completions, new ArrayList<>(completions.size()));
        }

        return Arrays.asList("");
    }
}
