package Snakes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventAdapter extends KeyAdapter {

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

    @Override
    public void keyPressed(KeyEvent event)
    {

        int key = event.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && (!rightDirection))
        {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection))
        {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyEvent.VK_UP) && (!downDirection))
        {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

        if ((key == KeyEvent.VK_DOWN) && (!upDirection))
        {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
    }

    public boolean getLeftDirection() { return leftDirection; }
    public boolean getRightDirection() { return rightDirection; }
    public boolean getUpDirection() { return upDirection; }
    public boolean getDownDirection() { return downDirection; }
}