package net.runelite.client.util;


import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import java.awt.*;

@Singleton
@Slf4j
public class AutomataUtil {
    Robot robot;

    public AutomataUtil() throws AWTException {
        robot = new Robot();
    }


    public void MoveToUIPoint(int x, int y){

    }
    public void MoveToScreenSpacePoint(int x, int y){
        HumanizeMouseMovement(x, y);
    }

    private void HumanizeMouseMovement(int x, int y){

    }

}
