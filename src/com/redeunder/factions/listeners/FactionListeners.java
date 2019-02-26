package com.redeunder.factions.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class FactionListeners implements Listener {

    public static ArrayList<String> creation_name = new ArrayList<>();
    public static ArrayList<String> creation_tag = new ArrayList<>();
    public static ArrayList<String> creation_confirm = new ArrayList<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (creation_name.contains(player.getName())) {
            // TODO:
        }
    }
}