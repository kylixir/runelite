package net.runelite.client.plugins.bblumbridgecows;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.ActorDeath;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ScheduledEvent;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.bblumbridgecows.BBLumbridgeCowsConfig;
import net.runelite.client.plugins.npchighlight.NpcMinimapOverlay;
import net.runelite.client.plugins.npchighlight.NpcSceneOverlay;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


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

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private BBCowSceneOverlay cowSceneOverlay;

    @Inject
    private ClientThread clientThread;




    @Getter(AccessLevel.PACKAGE)
    private final Set<NPC> activeCows = new HashSet<>();

    @Subscribe
    public void onScheduledEvent(ScheduledEvent event){
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        activeCows.clear();
    }

    @Subscribe
    public void onActorDeath(ActorDeath actorDeath){

    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned){
        NPC npc = npcSpawned.getNpc();
        System.out.println(npc.getName() + ": " + npc.getId());
        boolean isCow = npc.getName().equalsIgnoreCase("cow") || npc.getName().equalsIgnoreCase("cow calf");
        if (isCow){
            activeCows.add(npc);
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned){
        NPC npc = npcDespawned.getNpc();
        boolean isCow = npc.getName().equalsIgnoreCase("cow") || npc.getName().equalsIgnoreCase("cow calf");
        if(isCow){
            activeCows.remove(npc);
        }
    }


    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(cowSceneOverlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(cowSceneOverlay);
    }



    @Provides
    BBLumbridgeCowsConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(BBLumbridgeCowsConfig.class);
    }
}
