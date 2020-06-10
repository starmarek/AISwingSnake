package Frame;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import CSVReader.CSVReader;
import Constants.*;

public class AISwingSnake extends JFrame
{
    static JPanel mainPanel;
    static CSVReader csv;
    static String playerNickname;

    public AISwingSnake()
    {
        initUI();
    }

    private void initUI()
    {
        csv = new CSVReader();
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

    public static void switchToLeaderBoardScreen()
    {
        LeaderBoardScreen LeaderBoard = new LeaderBoardScreen();
        mainPanel.removeAll();
        mainPanel.add(LeaderBoard);
        mainPanel.revalidate();
        mainPanel.repaint();
        LeaderBoard.requestFocusInWindow();
    }

    public static void saveScore(int score) { csv.saveScore(score, playerNickname); }
    public static ArrayList<ArrayList<String>> getLeaderBoard() { return  csv.getParsedFile(); }

    public static void runGame()
    {
        EventQueue.invokeLater(() -> {
            JFrame ex = new AISwingSnake();
            ex.setVisible(true);
        });
    }
}