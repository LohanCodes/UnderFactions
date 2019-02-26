package com.redeunder.factions.events;

import com.redeunder.factions.enums.Reason;
import com.redeunder.factions.objects.Member;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionPlayerChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Member member;
    private Reason reason;

    public FactionPlayerChangeEvent(Member member, Reason reason) {
        this.member = member;
        this.reason = reason;
    }

    public Member getMember() {
        return member;
    }

    public Reason getReason() {
        return reason;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}