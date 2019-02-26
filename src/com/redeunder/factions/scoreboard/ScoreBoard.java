package com.redeunder.factions.scoreboard;

import com.redeunder.factions.Factions;
import com.redeunder.factions.objects.Member;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoard {

    public static void build(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("scoreboard", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("{location}");

        Member member = Factions.getInstance().members.get(player.getName());

        LineAdder lineAdder = new LineAdder(scoreboard, objective);
        lineAdder.setLine(0, "§0", "");
        lineAdder.setLine(0, " §fNível: ", "{mcMMO_level}");
        lineAdder.setLine(0, " §f", "");
    }
}