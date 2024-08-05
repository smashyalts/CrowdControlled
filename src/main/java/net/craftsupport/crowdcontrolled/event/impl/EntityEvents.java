package net.craftsupport.crowdcontrolled.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EntityEvents {
    public static void spawnEntity(String name, String type, boolean invulnerable) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Entity e = p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.valueOf(type));

            e.setCustomName(name);
            e.setCustomNameVisible(true);

            e.setInvulnerable(invulnerable);
        }
    }
}
