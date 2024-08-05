package net.craftsupport.crowdcontrolled.event;


import net.craftsupport.crowdcontrolled.event.impl.AttributeEvents;
import net.craftsupport.crowdcontrolled.event.impl.EntityEvents;
import net.craftsupport.crowdcontrolled.event.impl.PlayerEvents;
import net.craftsupport.crowdcontrolled.event.impl.WorldEvents;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    public static void execute(String type, List<Object> params) {
        switch (type) {
            case "modify_attribute" -> {
                AttributeEvents.modifyPlayerAttribute((String) params.get(0), (int) params.get(1), (String) params.get(2));
            }
            case "spawn_entity" -> {
                EntityEvents.spawnEntity((String) params.get(3), (String) params.get(4), (Boolean) params.get(5));
            }
            case "give_item" -> {
                PlayerEvents.giveItem((String) params.get(6), (int) params.get(7), (List<String>) params.get(8));
            }
            case "command" -> {
                PlayerEvents.executeCommand((String) params.get(9));
            }
            case "apply_effect" -> {
                PlayerEvents.applyEffect((String) params.get(10), (int) params.get(11), (int) params.get(12));
            }
            case "modify_block" -> {
                WorldEvents.modifyBlock((String) params.get(13), (List<Integer>) params.get(14));
            }
        }
    }
}
