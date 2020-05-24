package GameBoardObjects;

import java.awt.*;

public class HorizontalObstacle extends BaseBoardObjects
{
    private final int width = 250;
    private final int height = 30;

    public HorizontalObstacle()
    {
        loadImage("src/resources/obstacle25x3.png");
        init();
    }

    private void init()
    {
        pos_X = randNumber(5, 50);
        pos_Y = randNumber(45, 70);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(pos_X, pos_Y, width, height);
    }
}
