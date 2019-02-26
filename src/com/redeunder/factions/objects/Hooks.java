package com.redeunder.factions.objects;

public enum Hooks {

    MCMMO("mcMMO"), VAULT("Vault"), PERMISSIONSEX("PermissionsEx");

    private String name;

    Hooks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}