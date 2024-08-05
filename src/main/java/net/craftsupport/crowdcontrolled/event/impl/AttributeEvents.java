package net.craftsupport.crowdcontrolled.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.List;

public class AttributeEvents {
    public static void modifyPlayerAttribute(String type, int modifier, String operator) {
        for (Player p : Bukkit.getOnlinePlayers()) { // just gonna do it for all players
            switch (operator) {
                case "+":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() + modifier);
                case "add":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() + modifier);
                case "-":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() - modifier);
                case "subtract":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() - modifier);
                case "*":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() * modifier);
                case "multiply":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() * modifier);
                case "/":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() / modifier);
                case "divide":
                    p.getAttribute(Attribute.valueOf(type)).setBaseValue(p.getAttribute(Attribute.valueOf(type)).getBaseValue() / modifier);
            }
        }
    }
}
