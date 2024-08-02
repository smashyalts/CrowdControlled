package net.craftsupport.crowdcontrolled;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import lombok.extern.log4j.Log4j2;
import net.craftsupport.crowdcontrolled.command.DebugCommand;
import net.craftsupport.crowdcontrolled.command.ReloadCommand;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Log4j2(topic = "CrowdControlled")
public final class CrowdControlled extends JavaPlugin {
    PluginManager pm = getServer().getPluginManager();
    public static JavaPlugin plugin = CrowdControlled.getPlugin(CrowdControlled.class);


    public static ConfigFileHandler configHandler;

    @Override
    public void onEnable() {
        LOGGER.info("Registering Configs.");
        configHandler = new ConfigFileHandler();
        configHandler.loadFiles(this);

        LOGGER.info("Registering Commands.");
        CommandAPI.onLoad(new CommandAPIBukkitConfig(plugin).silentLogs(true));
        DebugCommand.register(plugin);
        ReloadCommand.register(plugin);
    }

    @Override
    public void onDisable() {

    }
}
