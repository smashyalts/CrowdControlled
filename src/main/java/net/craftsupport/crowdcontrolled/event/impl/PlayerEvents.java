package net.craftsupport.crowdcontrolled.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class PlayerEvents {
    public static void giveItem(String type, int count, List<String> lore) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            ItemStack item = new ItemStack(Material.getMaterial(type), count);
            ItemMeta meta = item.getItemMeta();

            meta.setLore(lore);

            p.getInventory().addItem(item);
        }
    }

    public static void executeCommand(List<String> commands) {
        for (String cmd : commands) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
        }
    }

    public static void applyEffect(String type, int duration, int amplifier) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type), duration, amplifier));
        }
    }
}
