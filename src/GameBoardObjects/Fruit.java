package GameBoardObjects;

import Snakes.PlayerSnake;

import java.awt.*;
import java.util.List;

public class Fruit extends BaseBoardObjects
{
    public Fruit()
    {
        loadImage("src/resources/apple.png");
    }

    protected boolean checkIfIsInObstacles(List<BaseBoardObjects> obstacleList)
    {
        for (BaseBoardObjects obstacle : obstacleList)
        {
            Rectangle obstacleRect = obstacle.getBounds();
            if (obstacleRect.intersects(this.getBounds()))
            {
                System.out.print("XD");
                return true;
            }
        }
        return false;
    }

    public void locate(List<BaseBoardObjects> obstacleList)
    {
        pos_Y = randNumber(0, 71);
        pos_X = randNumber(0, 71);

        while(checkIfIsInObstacles(obstacleList))
        {
            pos_Y = randNumber(0, 71);
            pos_X = randNumber(0, 71);
        }
    }

    public void check(PlayerSnake snake, List<BaseBoardObjects> obstacleList)
    {
        if ((snake.getHeadPosX() == this.getPosX()) && (snake.getHeadPosY() == this.getPosY()))
        {
            snake.setDotLength(snake.getDotLength() + 1);
            this.locate(obstacleList);
        }
    }
}
