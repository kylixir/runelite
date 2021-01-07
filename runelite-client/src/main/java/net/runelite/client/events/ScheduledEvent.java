package net.runelite.client.events;


import lombok.Data;

/*
    *  A class called regularly by timed fucntions.
*/

@Data
public class ScheduledEvent {
    private final float DeltaTime;
}
