package com.redeunder.factions.database;

import com.redeunder.factions.UnderFactions;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection connection;

    public static void connect(String url, int port, String db, String user, String pass, boolean sqlite, Plugin plugin) {
        try {
            if (sqlite) {
                File file = new File(plugin.getDataFolder(), "storage.db");
                if (!file.exists()) {
                    file.createNewFile();
                }
                // TODO: SQLite Driver Manager Connection URL
                UnderFactions.getInstance().console("Conectado ao database com sucesso! Usando SQLite");
            } else {
                connection = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + db, user, pass);
                UnderFactions.getInstance().console("Conectado ao database com sucesso! Usando MySQL");
            }

            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS underFactions (faction_name TEXT, faction_tag TEXT, faction_base TEXT, faction_bank TEXT, faction_claims TEXT, faction_allies TEXT, faction_enemies TEXT, faction_leader TEXT, faction_captains TEXT, faction_members TEXT, faction_recruits TEXT)");
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS underPlayers (member_name TEXT, member_faction TEXT, member_power INT, member_powerMax INT, member_kills INT, member_deaths INT)");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}