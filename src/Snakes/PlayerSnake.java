package Snakes;

import Constants.*;
import GameBoard.SnakePanel;

import javax.swing.ImageIcon;
import java.awt.*;

public class PlayerSnake
{
    private final int[] x = new int[Constants.B_WIDTH];
    private final int[] y = new int[Constants.B_HEIGHT];
    private final EventAdapter eventAdapter = new EventAdapter();
    private int dotLength;
    private Image ball;
    private Image head;

    public PlayerSnake()
    {
        initSnake();
        loadImages();
    }

    public int getHeadPosX() { return x[0]; }
    public int getHeadPosY() { return y[0]; }
    public int getDotLength() { return dotLength; }
    public EventAdapter getEventAdapter() { return eventAdapter; }

    private void initSnake()
    {
        dotLength = Constants.INITIAL_SNAKE_LENGTH;
        for (int z = 0; z < dotLength; z++)
        {
            x[z] = 50 - z * Constants.DOT_SIZE;
            y[z] = 50;
        }
    }

    private void loadImages()
    {
        ImageIcon tempBall = new ImageIcon("src/resources/snake_body_player.png");
        ball = tempBall.getImage();

        ImageIcon tempHead = new ImageIcon("src/resources/snake_head_player.png");
        head = tempHead.getImage();
    }

    public void move() {
        for (int z = dotLength; z > 0; z--)
        {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (eventAdapter.getLeftDirection())  { x[0] -= Constants.DOT_SIZE; }
        if (eventAdapter.getRightDirection()) { x[0] += Constants.DOT_SIZE; }
        if (eventAdapter.getUpDirection())    { y[0] -= Constants.DOT_SIZE; }
        if (eventAdapter.getDownDirection())  { y[0] += Constants.DOT_SIZE; }
    }

    public boolean checkCollisionWithBoard()
    {
        for (int z = dotLength; z > 0; z--)
        {
            if ((z > 4) && (getHeadPosX() == x[z]) && (getHeadPosY() == y[z]))
            {
                return false;
            }
        }

        if (getHeadPosY() >= Constants.B_HEIGHT - Constants.SCORE_PANEL_HEIGHT) { return false; }
        if (getHeadPosY() < 0) { return false; }
        if (getHeadPosX() >= Constants.B_WIDTH) { return false; }
        if (getHeadPosX() < 0) { return false; }

        //return true if collision was not detected
        return true;
    }

    public void draw(Graphics graphics, SnakePanel board)
    {
        graphics.drawImage(head, getHeadPosX(), getHeadPosY(), board);
        for (int z = 1; z<dotLength; z++)
            graphics.drawImage(ball, x[z], y[z], board);
    }

    public void incrementDots()
    {
        ++dotLength;
    }
}
