package net.runelite.client.plugins.bblumbridgecows;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsConfig;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import java.awt.*;

public class BBCowSceneOverlay extends Overlay {

    private final Client client;
    private final BBLumbridgeCowsConfig config;
    private final BBLumbridgeCowsPlugin plugin;

    @Inject
    BBCowSceneOverlay(Client client, BBLumbridgeCowsConfig config, BBLumbridgeCowsPlugin plugin)
    {
        this.client = client;
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics) {


        for (NPC npc : plugin.getActiveCows()){
            renderNPCOverlays(graphics, npc);
        }

        return null;
    }

    private void renderNPCOverlays(Graphics2D graphics,NPC actor){

        NPCComposition npcComposition = actor.getTransformedComposition();
        if (npcComposition == null || !npcComposition.isInteractible() || (actor.isDead()))
        {
            return;
        }
        Shape npcHull = actor.getConvexHull();
        Color col = new Color(45,45,45);
        renderPoly(graphics, config.getHighlightColor(), npcHull);
    }

    private void renderPoly(Graphics2D graphics, Color color, Shape polygon)
    {
        if (polygon != null)
        {
            graphics.setColor(color);
            graphics.setStroke(new BasicStroke(2));
            graphics.draw(polygon);
            graphics.setColor(ColorUtil.colorWithAlpha(color, color.getAlpha() / 12));
            graphics.fill(polygon);
        }
    }



}
