package com.redeunder.factions.scoreboard;

import com.redeunder.factions.UnderFactions;
import com.redeunder.factions.objects.Faction;
import com.redeunder.factions.objects.Member;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Board {

    public static void start() {
        new BukkitRunnable() {
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                    Objective objective = scoreboard.registerNewObjective("scoreboard", "dummy");

                    Member member = UnderFactions.getInstance().members.get(player.getName());
                    Faction faction = member.getFaction();

                    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                    objective.setDisplayName("{playerLocation}");

                    objective.getScore(Bukkit.getOfflinePlayer("§r")).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer(" §fNível: §a{mcMMO_level}")).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer(" §fPoder: §a" + member.getPower() + "/" + member.getPowerMax())).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer("§r§r")).setScore(0);

                    if (faction == null) {
                        objective.getScore(Bukkit.getOfflinePlayer("  §cSem facção")).setScore(0);
                    } else {
                        objective.getScore(Bukkit.getOfflinePlayer("  §e[" + faction.getTag() + "] " + faction.getName())).setScore(0);
                        objective.getScore(Bukkit.getOfflinePlayer("   §fPoder: §e" + faction.getPower() + "/" + faction.getPowerMax())).setScore(0);
                        objective.getScore(Bukkit.getOfflinePlayer("   §fMembros: §e" + faction.getAllOnline().size() + "/15")).setScore(0);
                    }

                    objective.getScore(Bukkit.getOfflinePlayer("§r§r§r")).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer(" §fCoins: §a{playerCoins}")).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer(" §fCash: §6[playerCash}")).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer("§r§r§r§r")).setScore(0);
                    objective.getScore(Bukkit.getOfflinePlayer("§eloja.redeunder.com")).setScore(0);

                    player.setScoreboard(scoreboard);
                }
            }
        }.runTaskTimer(UnderFactions.getInstance(), 150L, 150L);
    }
}