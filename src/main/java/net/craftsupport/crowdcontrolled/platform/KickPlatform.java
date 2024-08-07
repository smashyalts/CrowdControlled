package net.craftsupport.crowdcontrolled.platform;

import net.craftsupport.crowdcontrolled.config.Settings;
import uk.co.mistyknives.kick4j.Kick4J;
import uk.co.mistyknives.kick4j.Kick4JBuilder;
import uk.co.mistyknives.kick4j.api.channels.payload.Channel;
import uk.co.mistyknives.kick4j.auth.AuthCredential;
import uk.co.mistyknives.kick4j.events.EventType;
import uk.co.mistyknives.kick4j.events.impl.channel.ChannelFollowEvent;
import uk.co.mistyknives.kick4j.events.impl.channel.ChannelGiftedSubscriptionsEvent;
import uk.co.mistyknives.kick4j.events.impl.channel.ChannelSubscriptionEvent;
import uk.co.mistyknives.kick4j.events.impl.channel.ChannelWasRaidedEvent;
import uk.co.mistyknives.kick4j.util.Logger;

public class KickPlatform {

    public static Kick4J client;
    public static String username;
    public static int id;
    public static String ign;

    public KickPlatform(String username, String ign) {
        Channel.V2 channel = client.channels.cache.find(username);
        if (channel != null) {
            username = username;
            id = channel.getId();
            ign = ign;

            client = Kick4JBuilder.builder()
                    .credentials(new AuthCredential(Settings.KICK_USERNAME.getString(), Settings.KICK_PASSWORD.getString()))
                    .logType(Logger.DEFAULT)
                    .build();

            client.on(EventType.CHANNEL_SUBSCRIPTION, this::handleChannelSubscribe);
            client.on(EventType.CHANNEL_GIFTED_SUBSCRIPTIONS, this::handleChannelSubscribeGift);
            client.on(EventType.CHANNEL_WAS_RAIDED, this::handleChannelRaid);
            client.on(EventType.CHANNEL_FOLLOW, this::handleChannelFollow);
        } else {
            throw new IllegalArgumentException("Failed to find Kick Channel from username: " + username);
        }
    }

    private void handleChannelSubscribe(ChannelSubscriptionEvent event) {

    }

    private void handleChannelSubscribeGift(ChannelGiftedSubscriptionsEvent event) {

    }

    private void handleChannelRaid(ChannelWasRaidedEvent event) {

    }

    private void handleChannelFollow(ChannelFollowEvent event) {

    }
}
