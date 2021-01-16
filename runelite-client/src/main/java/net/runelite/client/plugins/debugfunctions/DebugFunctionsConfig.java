package net.runelite.client.plugins.debugfunctions;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.bblumbridgecows.BBLumbridgeCowsPlugin;

@ConfigGroup("test")
public interface DebugFunctionsConfig extends Config
{

    @ConfigItem(
            keyName = "clientTickDebug",
            name = "Client Tick Output",
            description = "Console outputs every client tick event."
    )
    default boolean showClientTickDebug()
    {
        return false;
    }

    @ConfigItem(
            keyName = "MousePosDebug",
            name = "Mouse Position Output",
            description = "Console outputs the XY and Window XY position of the cursor every mouse move."
    )
    default boolean showMousePosDebug()
    {
        return false;
    }



}
