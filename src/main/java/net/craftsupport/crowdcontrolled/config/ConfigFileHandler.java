package net.craftsupport.crowdcontrolled.config;

import net.craftsupport.crowdcontrolled.CrowdControlled;

import java.util.HashMap;
import java.util.Map;

public class ConfigFileHandler {

    private static Map<ConfigTypes, ConfigHandler> configs;

    public ConfigFileHandler() {
        configs = new HashMap<>();
    }

    public static ConfigHandler getFile(ConfigTypes type) {
        return configs.get(type);
    }

    public void loadFiles(CrowdControlled plugin) {
        registerFile(ConfigTypes.SETTINGS, new ConfigHandler(plugin, "config"));
        registerFile(ConfigTypes.MESSAGES, new ConfigHandler(plugin, "messages"));
        registerFile(ConfigTypes.EVENTS, new ConfigHandler(plugin, "events"));

        configs.values().forEach(ConfigHandler::saveDefaultConfig);
        Messages.setConfig(getFile(ConfigTypes.MESSAGES).getConfig());
        Settings.setConfig(getFile(ConfigTypes.SETTINGS).getConfig());
    }

    public void reloadFiles() {
        configs.values().forEach(ConfigHandler::reload);
    }

    public void registerFile(ConfigTypes type, ConfigHandler handler) {
        configs.put(type, handler);
    }
}
