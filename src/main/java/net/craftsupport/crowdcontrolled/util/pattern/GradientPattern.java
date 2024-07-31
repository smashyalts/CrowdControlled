package net.craftsupport.crowdcontrolled.util.pattern;

import net.craftsupport.crowdcontrolled.util.ColorAPI;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradientPattern implements MainPattern {

    Pattern pattern = Pattern.compile("\\{#([A-Fa-f0-9]{6})[>}](.*?)[<{]/#([A-Fa-f0-9]{6})}");

    @Override
    public String process(String string) {
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String start = matcher.group(1);
            String end = matcher.group(3);
            String val = matcher.group(2);
            string = string.replace(matcher.group(), ColorAPI.color(val, new Color(Integer.parseInt(start, 16)), new Color(Integer.parseInt(end, 16))));
        }

        return string;
    }
}
