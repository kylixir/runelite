package net.runelite.client.plugins.bblumbridgecows;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("BB")
public interface BBLumbridgeCowsConfig extends Config
{

    @ConfigItem(
            keyName = "enableRoutines",
            name = "Enable Routines",
            description = "Starts the service, vague i know."
    )
    default boolean isRoutineEnabled()
    {
        return false;
    }

}
