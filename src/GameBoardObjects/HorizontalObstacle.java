package GameBoardObjects;

import java.awt.*;

public class HorizontalObstacle extends BaseBoardObjects
{
    private int width;
    private int height;

    public HorizontalObstacle()
    {
        loadImage("src/resources/obstacle25x3.png");
        init();
    }

    private void init()
    {
        pos_X = randNumber(5, 50);
        pos_Y = randNumber(45, 70);
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(pos_X, pos_Y, width, height);
    }
}
