package GameBoardObjects;

import Constants.*;

public class Fruit extends BaseBoardObjects
{
    public Fruit()
    {
        loadImage("src/resources/apple.png");
    }

    public void locateFruit()
    {
        pos_X = (int) (Math.random() * Constants.RAND_POS_FRUIT_X) * Constants.DOT_SIZE;
        pos_Y = (int) (Math.random() * Constants.RAND_POS_FRUIT_Y) * Constants.DOT_SIZE;
    }
}
