package net.craftsupport.crowdcontrolled.events;


import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class TestEvent implements Listener {

   // Testing Attributes until we get subscriber/superchat events up and running
    @EventHandler
    public void onTest(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        player.getAttribute(Attribute.GENERIC_SCALE).setBaseValue(player.getAttribute(Attribute.GENERIC_SCALE).getValue() + 1);
    }
}
