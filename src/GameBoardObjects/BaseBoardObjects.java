package GameBoardObjects;

import Constants.Constants;
import GameBoardPanels.SnakePanel;

import javax.swing.*;
import java.awt.*;

public class BaseBoardObjects
{
    protected int pos_X;
    protected int pos_Y;
    protected Image image;

    public BaseBoardObjects() { }

    public int getPosX() { return pos_X; }
    public int getPosY() { return pos_Y; }

    protected void loadImage(String filename)
    {
        ImageIcon tempFruitImage = new ImageIcon(filename);
        image = tempFruitImage.getImage();
    }

    protected int randNumber(int min, int max)
    {
        return (min + (int) (Math.random() * ((max - min) + 1))) * 10;
    }

    public void draw(Graphics graphics, SnakePanel board)
    {
        graphics.drawImage(image, getPosX(), getPosY(), board);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(pos_X,pos_Y, Constants.DOT_SIZE,Constants.DOT_SIZE);
    }
}
