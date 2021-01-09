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
    public void keyTyped(KeyEvent e)
    {
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public MouseEvent mouseMoved(MouseEvent e)
    {
        if(e!=null){
            int i = 4;
        }

        if(config.showMousePosDebug()){

            long now = System.currentTimeMillis();
            long diff = now - lastMove;
            lastMove = now;

            System.out.println(e.toString());
        }
        return e;
    }
}