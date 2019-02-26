package com.redeunder.factions.objects;

import com.redeunder.factions.Factions;
import com.redeunder.factions.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private Faction faction;
    private int power;
    private int powerMax;
    private int kills;
    private int deaths;
    private ArrayList<Faction> invitations;

    public Member(String name, int power, int powerMax, int kills, int deaths) {
        this.name = name;
        this.power = power;
        this.powerMax = powerMax;
        this.kills = kills;
        this.deaths = deaths;
        this.invitations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Faction getFaction() {
        return faction;
    }

    public int getPower() {
        return power;
    }

    public int getPowerMax() {
        return powerMax;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public ArrayList<Faction> getInvitations() {
        return invitations;
    }

    public Role getRole() {
        if (faction.getLeader() == this) {
            return Role.LEADER;
        }
        if (faction.getCaptains().contains(this)) {
            return Role.CAPTAIN;
        }
        if (faction.getMembers().contains(this)) {
            return Role.MEMBER;
        }
        if (faction.getRecruits().contains(this)) {
            return Role.RECRUIT;
        }
        return Role.NONE;
    }

    public String getSymbol() {
        if (faction.getLeader() == this) {
            return "#";
        }
        if (faction.getCaptains().contains(this)) {
            return "*";
        }
        if (faction.getMembers().contains(this)) {
            return "+";
        }
        if (faction.getRecruits().contains(this)) {
            return "-";
        }
        return "";
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public boolean hasFaction() {
        return faction != null;
    }

    public static List<Member> getMembers() {
        return new ArrayList<>(Factions.getInstance().members.values());
    }

    public void saveMember() {
        // TODO: Method to save member.
    }
}