package net.craftsupport.crowdcontrolled.config;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public enum Settings {

    TWITCH_OAUTH("PLATFORM.TWITCH.OAUTH_TOKEN"),
    TWITCH_CHANNELS("PLATFORM.TWITCH.CHANNELS"),

    KICK_USERNAME("PLATFORM.KICK.USERNAME"),
    KICK_PASSWORD("PLATFORM.KICK.PASSWORD");

    @Setter
    private static FileConfiguration config;
    private final String path;

    Settings(String path) { this.path = path; }

    public List<String> getList() {
        return config.getStringList(this.path);
    }

    public List<Integer> getIntegerList() {
        return config.getIntegerList(this.path);
    }

    public String getString() {
        return config.getString(this.path);
    }

    public int getInt() {
        return config.getInt(this.path);
    }

    public boolean getBoolean() {
        return config.getBoolean(this.path);
    }

    public List<List<String>> getListOfStringList() {
        List<?> rawList = config.getList(this.path);
        List<List<String>> channelNames = new ArrayList<>();

        if (rawList != null) {
            for (Object obj : rawList) {
                if (obj instanceof List<?>) {
                    List<?> innerList = (List<?>) obj;
                    List<String> stringList = innerList.stream()
                            .map(Object::toString)
                            .collect(Collectors.toList());
                    channelNames.add(stringList);
                }
            }
        }

        return channelNames;
    }
}
