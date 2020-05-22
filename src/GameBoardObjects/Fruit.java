package GameBoardObjects;

import javax.swing.ImageIcon;
import java.awt.*;

import Constants.*;
import GameBoardPanels.SnakePanel;

public class Fruit
{
    private int pos_X;
    private int pos_Y;
    private Image fruitImage;

    public Fruit()
    {
        loadImage();
    }

    public int getFruitPosX() { return pos_X; }
    public int getFruitPosY() { return pos_Y; }

    private void loadImage()
    {
        ImageIcon tempFruitImage = new ImageIcon("src/resources/apple.png");
        fruitImage = tempFruitImage.getImage();
    }

    public void locateFruit()
    {
        pos_X = (int) (Math.random() * Constants.RAND_POS_FRUIT_X) * Constants.FRUIT_SIZE;
        pos_Y = (int) (Math.random() * Constants.RAND_POS_FRUIT_Y) * Constants.FRUIT_SIZE;
    }

    public void draw(Graphics graphics, SnakePanel board)
    {
        graphics.drawImage(fruitImage, getFruitPosX(), getFruitPosY(), board);
    }
}
