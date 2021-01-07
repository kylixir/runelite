package net.runelite.client.plugins.debugfunctions;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ScheduledEvent;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.ClientTick;
import javax.inject.Inject;


@PluginDescriptor(
        name = "Test",
        description = "For testing plugins",
        tags = {"dev", "development"},
        enabledByDefault = false
)
public class DebugFunctionsPlugin extends Plugin
{

    @Inject
    private MouseManager mouseManager;

    @Inject
    private KeyManager keyManager;

    @Inject
    private DebugFunctionsListener inputListener;

    @Inject
    private DebugFunctionsConfig config;

    @Subscribe
    public void onClientTick(ClientTick clientTick){
        if(config.showClientTickDebug()){
        System.out.println("Here is a client Tick");
        }
    }

    @Subscribe
    public void onScheduledEvent(ScheduledEvent event){
        System.out.println(event.getDeltaTime() + " SCH event woo");
    }

    @Override
    protected void startUp() throws Exception
    {
        mouseManager.registerMouseListener(inputListener);
        keyManager.registerKeyListener(inputListener);
    }

    @Override
    protected void shutDown() throws Exception
    {
        mouseManager.unregisterMouseListener(inputListener);
        keyManager.unregisterKeyListener(inputListener);
    }



    @Provides
    DebugFunctionsConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(DebugFunctionsConfig.class);
    }
}
