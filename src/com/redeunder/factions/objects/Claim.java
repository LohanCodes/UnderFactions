package com.redeunder.factions.objects;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

public class Claim {

    private World world;
    private int x;
    private int y;

    public Claim(World world, int x, int y) {
        this.world = world;
        this.x = x;
        this.y = y;
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Chunk getChunk() {
        return Bukkit.getWorld(world.getUID()).getChunkAt(x, y);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}