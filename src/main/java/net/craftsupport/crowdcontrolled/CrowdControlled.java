package net.craftsupport.crowdcontrolled;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.pubsub.ITwitchPubSub;
import lombok.extern.log4j.Log4j2;
<<<<<<< Updated upstream
=======
import net.craftsupport.crowdcontrolled.command.CommandHandler;
import net.craftsupport.crowdcontrolled.command.CommandTabCompleter;
import net.craftsupport.crowdcontrolled.config.ConfigFileHandler;
>>>>>>> Stashed changes
import net.craftsupport.crowdcontrolled.events.TestEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Log4j2(topic = "CrowdControlled")
public final class CrowdControlled extends JavaPlugin {
    public static ConfigFileHandler configHandler;

    PluginManager pm = getServer().getPluginManager();

    @Override
    public void onEnable() {
    pm.registerEvents(new TestEvent(), this);

<<<<<<< Updated upstream
    LOGGER.info("this plugin is under HEAVY development");
    ITwitchPubSub twitchPubSub = getServer().getServicesManager().load(ITwitchPubSub.class);
    twitchPubSub.listenForSubscriptionEvents(new OAuth2Credential("", ""), "1111");
=======
        LOGGER.info("Registering Configs.");
        configHandler = new ConfigFileHandler();
        configHandler.loadFiles(this);

        LOGGER.info("Registering Commands.");
        getCommand("chatcontrolled").setExecutor(new CommandHandler());
        getCommand("chatcontrolled").setTabCompleter(new CommandTabCompleter());

        LOGGER.info("this plugin is under HEAVY development");
        ITwitchPubSub twitchPubSub = getServer().getServicesManager().load(ITwitchPubSub.class);
        twitchPubSub.listenForSubscriptionEvents(new OAuth2Credential("", ""), "1111");
>>>>>>> Stashed changes

    }

    @Override
    public void onDisable() {

    }

    public static CrowdControlled getInstance() {
        return getPlugin(CrowdControlled.class);
    }
}
