package net.runelite.client;

import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.EventBus;

import javax.inject.Inject;

public class RoutineEventPoster implements Runnable {


    private static final GameTick GAME_TICK = new GameTick();

    @Inject
    private EventBus eventBus;


    RoutineEventPoster(){};

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(500);
                System.out.println("The separate tread is running.");

                if(!(eventBus == null)){ //NULL, GET INJECT WORKING
                    eventBus.post(GAME_TICK);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
