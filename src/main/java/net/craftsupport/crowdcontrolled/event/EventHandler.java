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
                AttributeEvents.modifyPlayerAttribute((String) params.get(4), (int) params.get(5), (String) params.get(6));
            }
            case "spawn_entity" -> {
                EntityEvents.spawnEntity((String) params.get(7), (String) params.get(8), (Boolean) params.get(9));
            }
            case "give_item" -> {
                PlayerEvents.giveItem((String) params.get(10), (Integer) params.get(11), params.get(12));
            }
            case "command" -> {
                PlayerEvents.executeCommand((String) params.get(13));
            }
            case "apply_effect" -> {
                PlayerEvents.applyEffect((String) params.get(14), (int) params.get(15), (int) params.get(16));
            }
            case "modify_block" -> {
                WorldEvents.modifyBlock((String) params.get(17), (List<Object>) params.get(18));
            }
        }
    }
}
