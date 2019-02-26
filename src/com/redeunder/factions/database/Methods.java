package com.redeunder.factions.database;

import com.redeunder.factions.objects.Faction;
import com.redeunder.factions.objects.Member;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Methods extends MySQL {

    public static boolean contains(String from, String location) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `" + from + "` WHERE `location` = ?");
            ps.setString(1, location);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void delete(String from) {
        try {
            PreparedStatement ps = connection.prepareStatement("TRUNCATE TABLE `" + from + "`");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `underPlayers`");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Member member = new Member(resultSet.getString("member_name"),
                        resultSet.getInt("member_power"),
                        resultSet.getInt("member_powerMax"),
                        resultSet.getInt("member_kills"),
                        resultSet.getInt("member_deaths"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public static List<Faction> getFactions() {
        return null;
    }
}