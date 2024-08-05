package net.craftsupport.crowdcontrolled.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class WorldEvents {
    public static void modifyBlock(String block, List<Integer> offset) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Bukkit.getWorld(p.getWorld().getName()).getBlockAt(p.getLocation().getBlockX() + offset.get(0), p.getLocation().getBlockY() + offset.get(1), p.getLocation().getBlockZ() + offset.get(2)).setType(Material.valueOf(block));
        }
    }
}
