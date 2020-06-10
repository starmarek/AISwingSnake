package GameBoardObjects;

class VerticalObstacle extends BaseBoardObjects
{
    private static int counter;

    public VerticalObstacle()
    {
        ++counter;
        loadImage("src/resources/obstacle3x25.png");
        init();
    }

    private void init()
    {
        width = image.getWidth(null);
        height = image.getHeight(null);
        initCords();
    }

    private void initCords()
    {
        pos_Y = randNumber(5, 30);
        if(counter % 2 == 0)
            pos_X = randNumber(5, 35);
        else
            pos_X = randNumber(45, 70);
    }
}
