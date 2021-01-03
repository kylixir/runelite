package net.runelite.client.plugins.debugfunctions;

import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

import javax.inject.Inject;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Instant;

public class DebugFunctionsListener extends MouseAdapter implements KeyListener
{
    private static final int HOTKEY = KeyEvent.VK_ALT;

    private Instant lastPress;

    private long lastMove;

    @Inject
    private DebugFunctionsPlugin plugin;

    @Inject
    private DebugFunctionsConfig config;


    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyPressed(KeyEvent e){
    }

    @Override
    public void keyReleased(KeyEvent e){
    }

    @Override
    public MouseEvent mouseMoved(MouseEvent e)
    {
        if(config.showMousePosDebug()){

            long now = System.currentTimeMillis();
            long diff = now - lastMove;
            lastMove = now;

            int truX = e.getX();
            int truY= e.getY();
            int absX = e.getXOnScreen();
            int absY = e.getYOnScreen();
            System.out.println("..X: " + truX + "   Y: " + truY +
                       "   ScreenX: " + absX + "   ScreenY: " + absY + "   Time diff: " + diff);
        }
        return e;
    }
}