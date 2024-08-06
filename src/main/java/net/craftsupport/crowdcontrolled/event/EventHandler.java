package net.craftsupport.crowdcontrolled.event;


import net.craftsupport.crowdcontrolled.event.impl.AttributeEvents;
import net.craftsupport.crowdcontrolled.event.impl.EntityEvents;
import net.craftsupport.crowdcontrolled.event.impl.PlayerEvents;
import net.craftsupport.crowdcontrolled.event.impl.WorldEvents;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class EventHandler {
    public static void execute(String type, LinkedHashMap params) {
        switch (type) {
            case "modify_attribute" -> {
                AttributeEvents.modifyPlayerAttribute((String) params.get("attribute_type"), (int) params.get("attribute_modifier"), (String) params.get("attribute_modifier_operator"));
            }
            case "spawn_entity" -> {
                EntityEvents.spawnEntity((String) params.get("name"), (String) params.get("entity"), (Boolean) params.get("invulnerable"));
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
}
