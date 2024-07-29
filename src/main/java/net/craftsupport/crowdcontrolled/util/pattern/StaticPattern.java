package net.craftsupport.crowdcontrolled.util.pattern;

import net.craftsupport.crowdcontrolled.util.ColorAPI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaticPattern implements MainPattern {

    public Pattern PATTERN = Pattern.compile("\\{#([A-Fa-f0-9]{6})}|[&]?#([A-Fa-f0-9]{6})");

    @Override
    public String process(String string) {
        Matcher matcher = PATTERN.matcher(string);
        while (matcher.find()) {
            String color = matcher.group(1);
            if (color == null) color = matcher.group(2);

            string = string.replace(matcher.group(), ColorAPI.getColor(color) + "");
        }

        return string;
    }
}
