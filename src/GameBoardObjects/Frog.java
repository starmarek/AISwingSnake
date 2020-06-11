package GameBoardObjects;

import java.awt.*;
import java.util.List;

public class Frog extends Fruit
{
    public Frog()
    {
        loadImage("src/resources/frog2.png");
    }

    private void moveRight() { pos_X += 10; }
    private void moveLeft() { pos_X -= 10; }
    private void moveUp() { pos_Y -= 10; }
    private void moveDown() { pos_Y += 10; }

    @Override
    public void locate(List<BaseBoardObjects> obstacleList)
    {
        pos_Y = randNumber(16, 55);
        pos_X = randNumber(16, 55);

        while(checkIfIsInObstacles(obstacleList))
        {
            pos_Y = randNumber(25, 54);
            pos_X = randNumber(25, 54);
        }
    }

    public Runnable createRunnable(Rectangle snakeRect)
    {
        Runnable tempRunnable = new Runnable() {
            @Override
            public void run() {
                move(snakeRect);
            }
        };
        return tempRunnable;
    }

    public void move(Rectangle snakeRectangle)
    {
        int checkRand = randNumber(0,2) / 10;
        if(checkRand % 2 == 1)
            return;

        int randomNumber = randNumber(0, 3) / 10;
        chaseFromDown(snakeRectangle, randomNumber);
        chaseFromUp(snakeRectangle, randomNumber);
    }

    private void chaseFromUp(Rectangle snakeRectangle, int randomNumber)
    {
        if(snakeRectangle.intersects(pos_X-150, pos_Y-150, 300, 150))
        {
            if(randomNumber <= 1)
                moveDown();
            else if(randomNumber == 2)
                moveRight();
            else if(randomNumber == 3)
                moveLeft();
        }
    }

    private void chaseFromDown(Rectangle snakeRectangle, int randomNumber)
    {
        if(snakeRectangle.intersects(pos_X-150, pos_Y, 300, 150))
        {
            if(randomNumber <= 1)
                moveUp();
            else if(randomNumber == 2)
                moveRight();
            else if(randomNumber == 3)
                moveLeft();
        }
    }

}
