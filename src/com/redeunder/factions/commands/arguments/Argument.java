package com.redeunder.factions.commands.arguments;

import com.redeunder.factions.commands.Executable;

public abstract class Argument implements Executable {

    private String name;
    private boolean consoleExecutable;
    private String[] aliases;
    private Argument[] children;
    private String label;

    public String getName() {
        return name;
    }

    public boolean isConsoleExecutable() {
        return consoleExecutable;
    }

    public String[] getAliases() {
        return aliases;
    }

    public Argument[] getChildren() {
        return children;
    }

    public String getLabel() {
        return label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConsoleExecutable(boolean consoleExecutable) {
        this.consoleExecutable = consoleExecutable;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public void setChildren(Argument[] children) {
        this.children = children;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Argument(String name, Argument... children) {
        this.name = name;
        this.children = children;
    }

    public Argument(String name, String[] aliases, Argument... children) {
        this(name, children);
        this.aliases = aliases;
    }
}