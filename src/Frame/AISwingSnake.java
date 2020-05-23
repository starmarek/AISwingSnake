package Frame;

import java.awt.*;
import javax.swing.*;

import Constants.*;

public class AISwingSnake extends JFrame
{
    static JPanel mainPanel;

    public AISwingSnake()
    {
        initUI();
    }

    private void initUI()
    {
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(new EntryScreen());
        add(mainPanel);
        setResizable(false);
        setPreferredSize(new Dimension(Constants.B_WIDTH, Constants.B_HEIGHT));
        pack();

        setTitle("AI Swing Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void switchToGameBoard()
    {
        GameBoard gameBoard = new GameBoard();
        mainPanel.removeAll();
        mainPanel.add(gameBoard);
        mainPanel.revalidate();
        mainPanel.repaint();
        gameBoard.requestFocusInSnakePanel();
    }

    public static void switchToGameOverScreen()
    {
        GameOverScreen gameOverScreen = new GameOverScreen();
        mainPanel.removeAll();
        mainPanel.add(gameOverScreen);
        mainPanel.revalidate();
        mainPanel.repaint();
        gameOverScreen.requestFocusInWindow();
    }

    public static void runGame()
    {
        EventQueue.invokeLater(() -> {
            JFrame ex = new AISwingSnake();
            ex.setVisible(true);
        });
    }
}