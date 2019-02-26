package com.redeunder.factions.commands;

import com.redeunder.factions.utilities.Statics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FactionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (strings.length == 0) {
                // TODO: open faction menu
                return true;
            }
            if (strings[0].equalsIgnoreCase("ajuda")) {

            }
        } else {
            sender.sendMessage(Statics.SOMENTE_PLAYERS);
        }
        return false;
    }
}
