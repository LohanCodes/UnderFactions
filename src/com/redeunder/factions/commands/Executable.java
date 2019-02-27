package com.redeunder.factions.commands;

import org.bukkit.command.CommandSender;

public interface Executable {

    void execute(CommandSender sender, String[] args);

}