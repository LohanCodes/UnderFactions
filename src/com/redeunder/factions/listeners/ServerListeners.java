package com.redeunder.factions.listeners;

import com.redeunder.factions.Factions;
import com.redeunder.factions.database.Methods;
import com.redeunder.factions.objects.Member;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ServerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!Methods.contains("underPlayers", player.getName())) {

        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Member member = Factions.getInstance().members.get(player.getName());
        if (member.hasFaction()) {
            for (Player p : (Factions.getInstance().members.get(player.getName())).getFaction().getAllOnline()) {
                p.getPlayer().sendMessage("§c" + player + " saiu.");
            }
        }
    }
}