package net.craftsupport.crowdcontrolled.command;

import org.bukkit.command.CommandSender;

public abstract class Command {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void execute(CommandSender sender, String args[]);

    public abstract String permission();

    public abstract boolean allowConsole();

}
