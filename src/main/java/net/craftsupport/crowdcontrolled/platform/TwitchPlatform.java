package net.craftsupport.crowdcontrolled.platform;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.api.IEventManager;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.eventsub.events.*;
import com.github.twitch4j.eventsub.socket.IEventSubSocket;
import com.github.twitch4j.eventsub.subscriptions.ChannelFollowTypeV2;
import com.github.twitch4j.eventsub.subscriptions.SubscriptionTypes;
import com.github.twitch4j.pubsub.domain.SubscriptionData;
import com.github.twitch4j.pubsub.events.ChannelSubscribeEvent;
import net.craftsupport.crowdcontrolled.config.Settings;

public class TwitchPlatform {

    public static TwitchClient client;
    public static String channelID;
    public static String IGN;

    public TwitchPlatform(String id, String ign) {
        channelID = id;
        IGN = ign;

        client = TwitchClientBuilder.builder()
                .withEnableEventSocket(true)
                .withDefaultAuthToken(new OAuth2Credential("twitch", Settings.TWITCH_OAUTH.getString()))
                .withEnableHelix(true)
                .build();

        client.getClientHelper().enableFollowEventListener(ign);

        IEventSubSocket socket = client.getEventSocket();
        IEventManager manager = client.getEventManager();

        socket.register(SubscriptionTypes.CHANNEL_SUBSCRIBE.prepareSubscription(builder -> builder.broadcasterUserId(channelID).build(), null));
        socket.register(SubscriptionTypes.CHANNEL_SUBSCRIPTION_GIFT.prepareSubscription(builder -> builder.broadcasterUserId(channelID).build(), null));
        socket.register(SubscriptionTypes.CHANNEL_RAID.prepareSubscription(builder -> builder.fromBroadcasterUserId(channelID).build(), null));
        socket.register(SubscriptionTypes.CHANNEL_FOLLOW_V2.prepareSubscription(builder -> builder.broadcasterUserId(channelID).build(), null));
        socket.register(SubscriptionTypes.CHANNEL_CHEER.prepareSubscription(builder -> builder.broadcasterUserId(channelID).build(), null));
        socket.register(SubscriptionTypes.CHANNEL_CHARITY_DONATE.prepareSubscription(builder -> builder.broadcasterUserId(channelID).build(), null));
        socket.register(SubscriptionTypes.HYPE_TRAIN_BEGIN.prepareSubscription(builder -> builder.broadcasterUserId(channelID).build(), null));

        manager.onEvent(ChannelSubscribeEvent.class, event -> handleChannelSubscribe(event.getData()));
        manager.onEvent(ChannelSubscriptionGiftEvent.class, this::handleChannelSubscribeGift);
        manager.onEvent(ChannelRaidEvent.class, this::handleChannelRaid);
        manager.onEvent(ChannelFollowTypeV2.class, this::handleChannelUserFollow);
        manager.onEvent(ChannelCheerEvent.class, this::handleChannelUserCheer);
        manager.onEvent(ChannelCharityDonateEvent.class, this::handleChannelCharityDonate);
        manager.onEvent(HypeTrainBeginEvent.class, this::handleChannelHypeTrainBegin);
    }

    private void handleChannelSubscribe(SubscriptionData event) {

    }

    private void handleChannelSubscribeGift(ChannelSubscriptionGiftEvent event) {

    }

    private void handleChannelRaid(ChannelRaidEvent event) {

    }

    private void handleChannelUserFollow(ChannelFollowTypeV2 event) {

    }

    private void handleChannelUserCheer(ChannelCheerEvent event) {

    }

    private void handleChannelCharityDonate(ChannelCharityDonateEvent event) {

    }

    private void handleChannelHypeTrainBegin(HypeTrainBeginEvent event) {

    }
}
