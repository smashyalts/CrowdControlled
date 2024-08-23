package net.craftsupport.crowdcontrolled;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import lombok.extern.log4j.Log4j2;
import net.craftsupport.crowdcontrolled.command.CrowdcontrolledCommand;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Log4j2(topic = "CrowdControlled")
public class CrowdControlled extends JavaPlugin {
    public static ConfigFileHandler configHandler;
    PluginManager pm = getServer().getPluginManager();

    public static CrowdControlled getInstance() {
        return getPlugin(CrowdControlled.class);
    }

    @Override
    public void onEnable() {
        LOGGER.info("Registering Configs.");
        configHandler = new ConfigFileHandler();
        configHandler.loadFiles(this);

        LOGGER.info("Registering Commands.");
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).silentLogs(true));
        CrowdcontrolledCommand.register(this);
    }

    @Override
    public void onDisable() {

    }
}
    // Schedule YouTube event checks
