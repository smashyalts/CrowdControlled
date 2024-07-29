package net.craftsupport.crowdcontrolled.config;

import net.craftsupport.crowdcontrolled.CrowdControlled;

import java.util.HashMap;
import java.util.Map;

public class ConfigFileHandler {

    private Map<ConfigTypes, ConfigHandler> configs;
    public ConfigFileHandler() { configs = new HashMap<>(); }

    public void loadFiles(CrowdControlled plugin) {
        registerFile(ConfigTypes.SETTINGS, new ConfigHandler(plugin, "config"));
        registerFile(ConfigTypes.MESSAGES, new ConfigHandler(plugin, "messages"));

        configs.values().forEach(ConfigHandler::saveDefaultConfig);

    }

    public ConfigHandler getFile(ConfigTypes type) { return configs.get(type); }

    public void reloadFiles() {
        configs.values().forEach(ConfigHandler::reload);
    }

    public void registerFile(ConfigTypes type, ConfigHandler handler) { configs.put(type, handler); }
}
