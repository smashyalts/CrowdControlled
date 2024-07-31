package net.craftsupport.crowdcontrolled;

import lombok.extern.log4j.Log4j2;
import net.craftsupport.crowdcontrolled.command.CommandHandler;
import net.craftsupport.crowdcontrolled.command.CommandTabCompleter;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Log4j2(topic = "CrowdControlled")
public final class CrowdControlled extends JavaPlugin {
    PluginManager pm = getServer().getPluginManager();
    public static ConfigFileHandler configHandler;

    @Override
    public void onEnable() {
        LOGGER.info("Registering Configs.");
        configHandler = new ConfigFileHandler();
        configHandler.loadFiles(this);

        LOGGER.info("Registering Commands.");
        getCommand("crowdcontrolled").setExecutor(new CommandHandler());
        getCommand("crowdcontrolled").setTabCompleter(new CommandTabCompleter());
    }

    @Override
    public void onDisable() {

    }
}
