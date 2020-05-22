package GameBoardPanels;

import GameBoardObjects.Fruit;
import Constants.Constants;
import Snakes.PlayerSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

public class SnakePanel extends JPanel implements ActionListener
{
    private boolean gameHasEnded, inGame;
    private final Timer timer;
    private final Fruit fruit;
    private final PlayerSnake playerSnake;
    private final KeyAdapter startAdapter;
    private JLabel arrows_pic;
    private JLabel arrows_text;
    private Image arrows;

    public SnakePanel()
    {
        fruit = new Fruit();
        playerSnake = new PlayerSnake();
        timer = new Timer(Constants.DELAY, this);
        startAdapter = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int event = e.getKeyCode();
                if (event == KeyEvent.VK_UP || event == KeyEvent.VK_DOWN || event == KeyEvent.VK_LEFT || event == KeyEvent.VK_RIGHT)
                {
                    removeKeyListener(startAdapter);
                    remove(arrows_pic);
                    remove(arrows_text);
                    addKeyListener(playerSnake.getEventAdapter());
                    fruit.locateFruit();
                    timer.start();
                    inGame = true;
                }
            }
        };
        setFocusable(true);
        setBackground(Color.black);
        setLayout(null);
        loadImages();
        addElements();
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        drawObjects(graphics);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
//        System.out.println(e.getWhen());
        if (inGame)
        {
            checkApple();
            playerSnake.move();
            inGame = playerSnake.checkCollisionWithBoard();
            if (!inGame) { timer.stop(); gameHasEnded = true;}
        }
        repaint();
    }

    private void drawObjects(Graphics graphics)
    {
        if (inGame)
        {
            fruit.draw(graphics, this);
            playerSnake.draw(graphics,this);
            Toolkit.getDefaultToolkit().sync();
        }

        if (gameHasEnded)
        {
            gameOver(graphics);
        }
    }

    private void checkApple()
    {
        if ((playerSnake.getHeadPosX() == fruit.getFruitPosX()) && (playerSnake.getHeadPosY() == fruit.getFruitPosY()))
        {
            playerSnake.setDotLength(playerSnake.getDotLength() + 1);
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

    public void initStartAdapter()
    {
        addKeyListener(startAdapter);
    }

    public int getScore()
    {
        return playerSnake.getDotLength() - Constants.INITIAL_SNAKE_LENGTH;
    }

    public void addSnakeObjectPropertyChangeListener(PropertyChangeListener listener)
    {
        playerSnake.addPropertyChangeListener(listener);
    }

    private void loadImages()
    {
        ImageIcon tempArrows = new ImageIcon("src/resources/arrows.png");
        arrows = tempArrows.getImage().getScaledInstance(Constants.HINT_ARROWS_SIZE_X, Constants.HINT_ARROWS_SIZE_Y, Image.SCALE_DEFAULT);
    }

    private void addElements()
    {
        arrows_pic = new JLabel(new ImageIcon(arrows));
        arrows_pic.setBounds(315, 300, Constants.HINT_ARROWS_SIZE_X, Constants.HINT_ARROWS_SIZE_Y);
        add(arrows_pic);

        arrows_text = new JLabel("Press arrow key to start the game!");
        arrows_text.setBounds(100, 425, 700, 30);
        arrows_text.setFont(new Font("Verdana", Font.BOLD, 30));
        arrows_text.setForeground(Color.white);
        add(arrows_text);
    }
}
