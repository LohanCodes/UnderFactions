package com.redeunder.factions;

import com.redeunder.factions.config.Messages;
import com.redeunder.factions.config.Settings;
import com.redeunder.factions.database.Methods;
import com.redeunder.factions.database.MySQL;
import com.redeunder.factions.listeners.FactionListeners;
import com.redeunder.factions.managers.FactionManager;
import com.redeunder.factions.managers.MemberManager;
import com.redeunder.factions.objects.Faction;
import com.redeunder.factions.objects.Member;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.HashMap;

public class Factions extends JavaPlugin {

    public static Factions getInstance() {
        return getPlugin(Factions.class);
    }

    public HashMap<String, Faction> factions = new HashMap<>();
    public HashMap<String, Member> members = new HashMap<>();

    public FactionManager factionManager = new FactionManager();
    public MemberManager memberManager = new MemberManager();

    public void onEnable() {
        new Settings(this);
        new Messages(this);

        MySQL.connect(Settings.getConfig().getString("MySQL.Host"),
                Settings.getConfig().getInt("MySQL.Port"),
                Settings.getConfig().getString("MySQL.Database"),
                Settings.getConfig().getString("MySQL.Username"),
                Settings.getConfig().getString("MySQL.Password"),
                Settings.getConfig().getBoolean("MySQL.SQLite"), this);

        initializeListeners();
        initializeCommands();

        long a = System.currentTimeMillis();
        int i = 0;
        int q = 0;

        try {
            for (Member member : Methods.getMembers()) {
                members.put(member.getName(), member);
                i++;
            }

            for (Faction faction : Methods.getFactions()) {
                factions.put(faction.getName(), faction);
                q++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long b = System.currentTimeMillis();
        long c = (b - a) / 1000L;

        console("Foram carregados " + i + " members em " + c + " segundos.");
        console("Foram carregados " + q + " factions em " + c + " segundos.");

        console("Habilitado com sucesso!");
    }

    public void onDisable() {
        Methods.delete("underPlayers");
        Methods.delete("underFactions");

        try {
            for (Member member : members.values()) {
                member.saveMember();
            }

            for (Faction faction : factions.values()) {
                faction.saveFaction();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MySQL.disconnect();

        console("Desabilitado com sucesso!");
    }

    private void initializeListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new FactionListeners(), this);
    }

    private void initializeCommands() {

    }

    public void console(String message) {
        Bukkit.getConsoleSender().sendMessage("§e[UnderFactions] " + message);
    }
}