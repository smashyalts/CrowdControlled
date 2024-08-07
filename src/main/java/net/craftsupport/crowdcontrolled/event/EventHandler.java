package net.craftsupport.crowdcontrolled.event;


import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
import net.craftsupport.crowdcontrolled.config.ConfigTypes;
import net.craftsupport.crowdcontrolled.event.impl.AttributeEvents;
import net.craftsupport.crowdcontrolled.event.impl.EntityEvents;
import net.craftsupport.crowdcontrolled.event.impl.PlayerEvents;
import net.craftsupport.crowdcontrolled.event.impl.WorldEvents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class EventHandler {
    public static final String PLATFORM_TWITCH = "twitch";
    public static final String PLATFORM_KICK = "kick";
    public static final String PLATFORM_YOUTUBE = "youtube";

    public static final String EVENT_SUB = "sub";
    public static final String EVENT_SUB_GIFT = "subgift";
    public static final String EVENT_RAID = "raid";
    public static final String EVENT_CHEER = "cheer";
    public static final String EVENT_DONATE = "donate";
    public static final String EVENT_FOLLOW = "follow";
    public static final String EVENT_HYPETRAIN = "train";


    public static void execute(String type, LinkedHashMap params) {
        switch (type) {
            case "modify_attribute" -> {
                AttributeEvents.modifyPlayerAttribute((String) params.get("attribute_type"), (int) params.get("attribute_modifier"), (String) params.get("attribute_modifier_operator"));
            }
            case "spawn_entity" -> {
                EntityEvents.spawnEntity((String) params.get("name"), (String) params.get("entity"), (Integer) params.get("amount"), (Boolean) params.get("invulnerable"));
            }
            case "give_item" -> {
                PlayerEvents.giveItem((String) params.get("item"), (int) params.get("count"), (List<String>) params.get("lore"));
            }
            case "command" -> {
                PlayerEvents.executeCommand((List<String>) params.get("commands"));
            }
            case "apply_effect" -> {
                PlayerEvents.applyEffect((String) params.get("effect"), (int) params.get("duration"), (int) params.get("amplifier"));
            }
            case "modify_block" -> {
                WorldEvents.modifyBlock((String) params.get("block"), (List<Integer>) params.get("offset"));
            }
        }
    }

    public static void handleEvent(String platform, String type) {

        ArrayList config = (ArrayList) ConfigFileHandler.getFile(ConfigTypes.EVENTS).getConfig().get("Events");

        for (int i = 0; i < config.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) ((LinkedHashMap) config.get(i)).get(i + 1);

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(map.toString());
            }

            List<String> plt = (List<String>) map.get("platform");
            List<String> trigger = (List<String>) map.get("event");
            String evtType = (String) map.get("action");
            LinkedHashMap params = (LinkedHashMap) map.get("values");


            for (String s : plt) {
                if (s.equals(platform)) {
                    for (String t : trigger) {
                        if (t.equals(type)) {
                            execute(evtType, params);
                        }
                    }
                }
            }
        }
    }
}
