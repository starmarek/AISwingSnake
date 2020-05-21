package GameBoard;

import BoardObjects.Fruit;
import Constants.Constants;
import Snakes.PlayerSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakePanel extends JPanel implements ActionListener
{
    private boolean inGame = true;
    private Timer timer;
    private final Fruit fruit;
    private final PlayerSnake playerSnake;

    public SnakePanel()
    {
        fruit = new Fruit();
        playerSnake = new PlayerSnake();
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        drawObjects(graphics);
    }

    private void drawObjects(Graphics graphics)
    {
        if (inGame)
        {
            fruit.draw(graphics, this);
            playerSnake.draw(graphics,this);
            Toolkit.getDefaultToolkit().sync();
        }
        else {
            gameOver(graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (inGame)
        {
            checkApple();
            playerSnake.move();
            inGame = playerSnake.checkCollisionWithBoard();
            if (!inGame) { timer.stop(); }
        }
        repaint();
    }

    private void checkApple()
    {
        if ((playerSnake.getHeadPosX() == fruit.getFruitPosX()) && (playerSnake.getHeadPosY() == fruit.getFruitPosY()))
        {
            playerSnake.incrementDots();
            fruit.locateFruit();
        }
    }

    private void gameOver(Graphics graphics)
    {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 22);
        FontMetrics metr = getFontMetrics(small);

        graphics.setColor(Color.white);
        graphics.setFont(small);
        graphics.drawString(msg, (Constants.B_WIDTH - metr.stringWidth(msg)) / 2, Constants.B_HEIGHT / 2);
    }

    public void initGame()
    {
        addKeyListener(playerSnake.getEventAdapter());
        fruit.locateFruit();
        timer = new Timer(Constants.DELAY, this);
        timer.start();
    }
}
