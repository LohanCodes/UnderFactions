package com.redeunder.factions.objects;

import com.redeunder.factions.Factions;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Faction {

    private String name;
    private String tag;
    private Location base;
    private Member leader;
    private ArrayList<Claim> claims;
    private ArrayList<Member> captains;
    private ArrayList<Member> members;
    private ArrayList<Member> recruits;

    public Faction(String name, String tag, Member leader) {
        this.name = name;
        this.tag = tag;
        this.leader = leader;
        this.claims = new ArrayList<>();
        this.captains = new ArrayList<>();
        this.members = new ArrayList<>();
        this.recruits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public Member getLeader() {
        return leader;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public ArrayList<Member> getCaptains() {
        return captains;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Member> getRecruits() {
        return recruits;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }

    public void setCaptains(ArrayList<Member> captains) {
        this.captains = captains;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setRecruits(ArrayList<Member> recruits) {
        this.recruits = recruits;
    }

    public static List<Faction> getFactions() {
        return new ArrayList<>(Factions.getInstance().factions.values());
    }

    public void saveFaction() {
        // TODO: Method to save faction.
    }
}