package net.runelite.client.plugins.bblumbridgecows;

import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

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

    @Alpha
    @ConfigItem(
            position = 4,
            keyName = "cowColor",
            name = "Highlight Color",
            description = "Color of the NPC highlight"
    )
    default Color getHighlightColor()
    {
        return Color.GREEN;
    }

}
