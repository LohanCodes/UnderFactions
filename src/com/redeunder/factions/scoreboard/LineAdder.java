package com.redeunder.factions.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class LineAdder {

    private Scoreboard scoreboard;
    private Objective objective;

    public LineAdder(Scoreboard scoreboard, Objective objective) {
        this.scoreboard = scoreboard;
        this.objective = objective;
    }

    public void setLine(int line, String prefix, String suffix) {
        Team team = scoreboard.registerNewTeam("line" + line);
        team.setSuffix(suffix);
        team.addPlayer(Bukkit.getOfflinePlayer(prefix));
        objective.getScore(Bukkit.getOfflinePlayer(prefix).getName()).setScore(line);
    }
}