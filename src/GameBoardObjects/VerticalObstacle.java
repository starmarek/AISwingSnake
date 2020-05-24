package GameBoardObjects;

import java.awt.*;

class VerticalObstacle extends BaseBoardObjects
{
    private static int counter;
    private final int width = 30;
    private final int height = 250;

    public VerticalObstacle()
    {
        ++counter;
        loadImage("src/resources/obstacle3x25.png");
        init();
    }

    private void init()
    {
        pos_Y = randNumber(5, 30);
        if(counter % 2 == 0)
            pos_X = randNumber(5, 35);
        else
            pos_X = randNumber(45, 70);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(pos_X, pos_Y, width, height);
    }
}
