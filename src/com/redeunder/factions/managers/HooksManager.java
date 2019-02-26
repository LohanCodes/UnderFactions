package com.redeunder.factions.managers;

import com.redeunder.factions.objects.Hooks;
import org.bukkit.Bukkit;

public class HooksManager {

    public static boolean isHooked(Hooks hook) {
        return Bukkit.getPluginManager().getPlugin(hook.getName()) != null;
    }
}