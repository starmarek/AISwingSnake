package GameBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import BoardObjects.Fruit;
import Constants.*;
import Snakes.*;

public class Board extends JPanel implements ActionListener {

    private boolean inGame = true;
    private Timer timer;
    private final Fruit fruit;
    private final PlayerSnake playerSnake;

    public Board()
    {
        fruit = new Fruit();
        playerSnake = new PlayerSnake();
        initBoard();
    }

    private void initBoard()
    {
        addKeyListener(playerSnake.getEventAdapter());
        setBackground(Color.black);
        setFocusable(true);
        initGame();
    }

    private void initGame()
    {
        fruit.locateFruit();
        timer = new Timer(Constants.DELAY, this);
        timer.start();
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
            inGame = playerSnake.checkCollisionWithBoard();
            if (!inGame) { timer.stop(); }
            playerSnake.move();
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
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        graphics.setColor(Color.white);
        graphics.setFont(small);
        graphics.drawString(msg, (Constants.B_WIDTH - metr.stringWidth(msg)) / 2, Constants.B_HEIGHT / 2);
    }
}