package com.redeunder.factions.commands;

import com.redeunder.factions.commands.arguments.Argument;
import com.redeunder.factions.utilities.Statics;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public abstract class Command implements CommandExecutor, Executable {

    private boolean registered;
    private Argument[] arguments;

    public boolean isRegistered() {
        return registered;
    }

    public Argument[] getArguments() {
        return arguments;
    }

    public Command(Argument... arguments) {
        this.arguments = arguments;
    }

    public void register(JavaPlugin plugin, String name) {
        plugin.getCommand(name).setExecutor(this);
        registered = true;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {
        if (args.length > 0) {
            for (Argument argument : arguments) {
                if (argument != null) {
                    int i = 1;
                    Argument a = null;
                    Argument[] c = argument.getChildren();
                    if (c != null && c.length > 0) {
                        for (int j = 0; j < c.length; j++) {
                            Argument cc = c[j];
                            if (args.length > i && canExecute(cc, args[i])) {
                                a = cc;
                                a.setLabel(cc.getName());
                                i++;
                            }
                        }
                    }

                    if (a == null && canExecute(argument, args[0])) {
                        a = argument;
                        a.setLabel(args[0]);
                    }

                    if (a != null) {
                        if (!(sender instanceof Player) && !a.isConsoleExecutable()) {
                            sender.sendMessage(Statics.SOMENTE_PLAYERS);
                            return true;
                        }

                        a.execute(sender, Arrays.copyOfRange(args, i, args.length));
                        return true;
                    }
                }
            }
        }
        execute(sender, args);
        return true;
    }

    private boolean canExecute(Argument argument, String label) {
        return argument.getName().equalsIgnoreCase(label) || ArrayUtils.contains(argument.getAliases(), label);
    }
}