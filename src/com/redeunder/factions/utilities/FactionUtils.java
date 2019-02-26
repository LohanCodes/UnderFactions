package com.redeunder.factions.utilities;

import com.redeunder.factions.Factions;
import com.redeunder.factions.config.Messages;
import com.redeunder.factions.enums.Reason;
import com.redeunder.factions.events.FactionPlayerChangeEvent;
import com.redeunder.factions.objects.Faction;
import com.redeunder.factions.objects.Member;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FactionUtils {

    public static void create(Member member, String name, String tag) {
        Player player = Bukkit.getPlayer(member.getName());

        if (member.hasFaction()) {
            player.sendMessage("§cVocê já possui uma facção.");
            return;
        }
        if (tag.length() != 3) {
            player.sendMessage("§cA tag da sua facção pode conter somente 3 caracteres.");
            return;
        }
        if ((name.length() < 5) || (name.length() > 16)) {
            player.sendMessage("§cO nome da sua facção é pequeno ou grande demais.");
            return;
        }
        if (Factions.getInstance().factionManager.isAlreadyTag(tag)) {
            player.sendMessage("§cJá existe uma facção com essa tag.");
            return;
        }
        if (Factions.getInstance().factionManager.isAlreadyName(name)) {
            player.sendMessage("§cJá existe uma facção com esse nome.");
            return;
        }
        if (Factions.getInstance().factionManager.containsSpecialCharacter(tag)) {
            player.sendMessage("§cA tag da sua facção contém caracteres inválidos.");
            return;
        }
        if (Factions.getInstance().factionManager.containsSpecialCharacter(name)) {
            player.sendMessage("§cO nome da sua facção contém caracteres inválidos.");
            return;
        }

        player.sendMessage("§eYEAH! Facção criada com sucesso!");

        Faction faction = new Faction(name, tag, member);
        member.setFaction(faction);
        Factions.getInstance().factions.put(name, faction);

        FactionPlayerChangeEvent event = new FactionPlayerChangeEvent(member, Reason.CRIAR);
        Bukkit.getPluginManager().callEvent(event);
    }
}