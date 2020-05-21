package AISwingSnake;

import java.awt.*;
import javax.swing.*;

import GameBoard.Board;
import EntryScreen.EntryScreen;
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
        mainPanel.add(new EntryScreen(), "entry");
        add(mainPanel);
        setResizable(false);
        setPreferredSize(new Dimension(Constants.B_WIDTH, Constants.B_HEIGHT));
        pack();

        setTitle("AI Swing Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void gameOn()
    {
        Board board = new Board();
        mainPanel.removeAll();
        mainPanel.add(board, "board");
        mainPanel.revalidate();
        mainPanel.repaint();
        board.requestFocusInSnakePanel();
    }

    public static void runGame()
    {
        EventQueue.invokeLater(() -> {
            JFrame ex = new AISwingSnake();
            ex.setVisible(true);
        });
    }
}