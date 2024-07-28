package net.craftsupport.crowdcontrolled;

import net.craftsupport.crowdcontrolled.events.testEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CrowdControlled extends JavaPlugin {
    Logger log = getLogger();
    PluginManager pm = getServer().getPluginManager();
    @Override
    public void onEnable() {
    pm.registerEvents(new testEvent(), this);
        // Plugin startup logic
        log.info("this plugin is under HEAVY development");
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
