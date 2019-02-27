package com.redeunder.factions.commands.arguments;

import com.redeunder.factions.Factions;
import com.redeunder.factions.enums.Reason;
import com.redeunder.factions.events.FactionPlayerChangeEvent;
import com.redeunder.factions.objects.Faction;
import com.redeunder.factions.objects.Member;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateArgument extends Argument {

    public CreateArgument() {
        super("criar", new String[] {"create"});
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Member member = Factions.getInstance().members.get(player.getName());

        if (member.hasFaction()) {
            player.sendMessage("§cVocê já é membro de uma facção.");
            return;
        }

        if (args.length == 0) {
            player.sendMessage("§cModo correto: /f criar (nome) (tag)");
            return;
        }

        if (args.length == 1) {
            player.sendMessage("§cModo correto: /f criar " + args[0] + " (tag)");
            return;
        }

        String name = args[0];
        String tag = args[1];

        if (tag.length() > 3) {
            player.sendMessage("§cA tag da sua facção deve ter no máximo 3 caractéres.");
            return;
        }

        if (tag.length() < 3) {
            player.sendMessage("§cA tag da sua facção deve ter no mínimo 3 caractéres.");
            return;
        }

        if (name.length() < 5) {
            player.sendMessage("§cO nome da sua facção deve ter no mínimo 5 caractéres.");
            return;
        }

        if (name.length() > 16) {
            player.sendMessage("§cO nome da sua facção deve ter no máximo 16 caractéres.");
            return;
        }

        if (Factions.getInstance().factionManager.isAlreadyTag(tag)) {
            player.sendMessage("§cJá existe uma facção com a tag " + tag + ".");
            return;
        }

        if (Factions.getInstance().factionManager.isAlreadyName(name)) {
            player.sendMessage("§cJá existe uma facção com o nome " + name + ".");
            return;
        }

        if (Factions.getInstance().factionManager.containsSpecialCharacter(tag)) {
            player.sendMessage("§cA tag da sua facção contém caractéres inválidos.");
            return;
        }

        if (Factions.getInstance().factionManager.containsSpecialCharacter(name)) {
            player.sendMessage("§cO nome da sua facção contém caractéres inválidos.");
            return;
        }

        Faction faction = new Faction(name, tag, member);
        member.setFaction(faction);
        Factions.getInstance().factions.put(name, faction);

        FactionPlayerChangeEvent event = new FactionPlayerChangeEvent(member, Reason.CRIAR);
        Bukkit.getPluginManager().callEvent(event);

        player.sendMessage("§aYEAH! Facção §f[" + tag + "] &acriada com sucesso!");
    }
}