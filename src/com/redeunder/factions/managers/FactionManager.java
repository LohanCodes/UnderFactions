package com.redeunder.factions.managers;

import com.redeunder.factions.Factions;
import com.redeunder.factions.objects.Faction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactionManager {

    public Faction getFactionByTag(String tag) {
        for (Faction faction : Factions.getInstance().factions.values()) {
            if (faction.getTag().equalsIgnoreCase(tag.toUpperCase())) {
                return faction;
            }
        }
        return null;
    }

    public Faction getFactionByName(String name) {
        for (Faction faction : Factions.getInstance().factions.values()) {
            if (faction.getName().equalsIgnoreCase(name.toUpperCase())) {
                return faction;
            }
        }
        return null;
    }

    public boolean isAlreadyTag(String tag) {
        for (Faction faction : Factions.getInstance().factions.values()) {
            if (faction.getTag().equalsIgnoreCase(tag.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlreadyName(String name) {
        for (Faction faction : Factions.getInstance().factions.values()) {
            if (faction.getName().equalsIgnoreCase(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSpecialCharacter(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9].*");
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) return true;
        return false;
    }
}