package com.redeunder.factions.commands;

import com.redeunder.factions.Factions;
import com.redeunder.factions.commands.arguments.Argument;
import com.redeunder.factions.objects.Member;
import com.redeunder.factions.utilities.Statics;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FactionCommand extends Command {

    public FactionCommand(Argument... arguments) {
        super(arguments);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Statics.SOMENTE_PLAYERS);
            return;
        }

        Player player = (Player) sender;
        Member member = Factions.getInstance().members.get(player.getName());
        if (member.hasFaction()) {
            // TODO: Open Main Faction View Inventory
        } else {
            // TODO: Open Help View Inventory
        }
    }
}