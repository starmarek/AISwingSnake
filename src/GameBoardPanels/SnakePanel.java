package GameBoardPanels;

import GameBoardObjects.Fruit;
import Constants.Constants;
import GameBoardObjects.TimeDisplay;
import Snakes.PlayerSnake;
import Frame.AISwingSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

public class SnakePanel extends JPanel implements ActionListener
{
    private boolean inGame;
    private final Timer timer;
    private final Fruit fruit;
    private final PlayerSnake playerSnake;
    private final KeyAdapter startAdapter;
    private final KeyAdapter resumeAdapter;
    private JLabel arrows_pic;
    private JLabel arrows_text;
    private JLabel pause_text;
    private JLabel pause_hint;
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
                    TimeDisplay.startCountDown(false);
                    inGame = true;
                }
            }
        };
        resumeAdapter = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int event = e.getKeyCode();
                if (event == KeyEvent.VK_R)
                {
                    resumeGame();
                    addKeyListener(playerSnake.getEventAdapter());
                    removeKeyListener(resumeAdapter);
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
        if (inGame)
        {
            checkApple();
            playerSnake.move();
            inGame = playerSnake.checkCollisionWithBoard();
            if (!inGame) { timer.stop(); TimeDisplay.stopCountDown(); gameOver(); }
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
    }

    private void checkApple()
    {
        if ((playerSnake.getHeadPosX() == fruit.getFruitPosX()) && (playerSnake.getHeadPosY() == fruit.getFruitPosY()))
        {
            playerSnake.setDotLength(playerSnake.getDotLength() + 1);
            fruit.locateFruit();
        }
    }

    private void gameOver()
    {
        JLabel arrows_text = new JLabel("Game Over");
        arrows_text.setBounds(275, 325, 700, 30);
        arrows_text.setFont(new Font("Verdana", Font.BOLD, 40));
        arrows_text.setForeground(Color.white);
        add(arrows_text);

        Timer gameOverTimer = new Timer(1000, null);
        gameOverTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOverTimer.stop();
                AISwingSnake.switchToGameOverScreen();
            }
        });
        gameOverTimer.start();
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

    public void pauseGame()
    {
        if (!timer.isRunning())
            return;
        timer.stop();
        TimeDisplay.stopCountDown();
        removeKeyListener(playerSnake.getEventAdapter());

        pause_text = new JLabel("GAME PAUSED");
        pause_text.setBounds(200, 300, 600, 60);
        pause_text.setFont(new Font("Verdana", Font.BOLD, 50));
        pause_text.setForeground(Color.white);
        add(pause_text);

        pause_hint = new JLabel("Press r key to resume");
        pause_hint.setBounds(225, 380, 700, 30);
        pause_hint.setFont(new Font("Verdana", Font.BOLD, 30));
        pause_hint.setForeground(Color.white);
        add(pause_hint);

        addKeyListener(resumeAdapter);
        repaint();
    }

    public void resumeGame()
    {
        timer.start();
        TimeDisplay.startCountDown(true);
        remove(pause_text);
        remove(pause_hint);
    }
}
