package net.craftsupport.crowdcontrolled.config;

import lombok.Getter;
import lombok.Setter;
import net.craftsupport.crowdcontrolled.util.TextUtility;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

@Getter
public enum Messages {

    SERVER_NAME("SERVER_NAME"),
    PERMISSION_DENY("PERMISSION_DENY"),
    RELOADING("RELOADING"),
    RELOADED("RELOADED"),
    ERROR("ERROR"),
    INCORRECT_USAGE("INCORRECT_USAGE"),
    COMMAND_PLAYER_ONLY("COMMAND_PLAYER_ONLY");

    @Setter
    private static FileConfiguration config;
    private final String path;

    Messages(String path) {
        this.path = path;
    }

    public String getString() {
        return config.getString(this.path);
    }

    public String get(Object... replacements) {
        Object value = config.get(this.path);

        String message;
        if (value == null) {
            message = TextUtility.color(SERVER_NAME.get() + "&r&7 Message not found: " + this.path);
        } else {
            message = value instanceof List ? TextUtility.fromList((List<?>) value) : value.toString();
        }
        return TextUtility.color(replace(message, replacements));
    }

    public void send(CommandSender receiver, Object... replacements) {
        if (receiver == null) return;

        Object value = config.get(this.path);

        String message;
        if (value == null) {
            message = TextUtility.color(SERVER_NAME.get() + "&r&7 Message not found: " + this.path);
        } else {
            message = value instanceof List ? TextUtility.fromList((List<?>) value) : value.toString();
        }

        if (!message.isEmpty()) {
            receiver.sendMessage(TextUtility.color(replace(message, replacements)));
        }
    }

    private String replace(String message, Object... replacements) {
        for (int i = 0; i < replacements.length; i += 2) {
            if (i + 1 >= replacements.length) break;
            message = message.replace(String.valueOf(replacements[i]), String.valueOf(replacements[i + 1]));
        }

        String prefix = config.getString(SERVER_NAME.getPath());
        return message.replace("%server_name%", prefix != null && !prefix.isEmpty() ? prefix : "");
    }
}
