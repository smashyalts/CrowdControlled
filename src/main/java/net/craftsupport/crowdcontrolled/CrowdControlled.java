package net.craftsupport.crowdcontrolled;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.pubsub.ITwitchPubSub;
import lombok.extern.log4j.Log4j2;
import net.craftsupport.crowdcontrolled.events.TestEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Log4j2(topic = "CrowdControlled")
public final class CrowdControlled extends JavaPlugin {
    PluginManager pm = getServer().getPluginManager();

    @Override
    public void onEnable() {
    pm.registerEvents(new TestEvent(), this);

    LOGGER.info("this plugin is under HEAVY development");
    ITwitchPubSub twitchPubSub = getServer().getServicesManager().load(ITwitchPubSub.class);
    twitchPubSub.listenForSubscriptionEvents(new OAuth2Credential("", ""), "1111");

    }

    @Override
    public void onDisable() {

    }
}
