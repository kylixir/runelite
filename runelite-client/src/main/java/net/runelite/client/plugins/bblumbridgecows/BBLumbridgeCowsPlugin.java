package net.runelite.client.plugins.bblumbridgecows;

import com.google.inject.Provides;
import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.ActorDeath;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ScheduledEvent;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.bblumbridgecows.BBLumbridgeCowsConfig;

import javax.inject.Inject;
import java.awt.*;


@PluginDescriptor(
        name = "Cows",
        description = "First run at thing",
        tags = {"dev", "development, BB"},
        enabledByDefault = false
)
public class BBLumbridgeCowsPlugin extends Plugin
{


    @Inject
    private MouseManager mouseManager;

    @Inject
    private KeyManager keyManager;

    @Inject
    private BBLumbridgeCowsConfig config;




    @Subscribe
    public void onScheduledEvent(ScheduledEvent event){
    }

    @Subscribe
    public void onActorDeath(ActorDeath actorDeath){

    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned){
        NPC npc = npcSpawned.getNpc();
        System.out.println(npc.getName() + ": " + npc.getId());
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned){

    }


    @Override
    protected void startUp() throws Exception
    {
    }

    @Override
    protected void shutDown() throws Exception
    {
    }



    @Provides
    BBLumbridgeCowsConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(BBLumbridgeCowsConfig.class);
    }
}
