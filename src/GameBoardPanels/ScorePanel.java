package GameBoardPanels;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel
{
    private JLabel score;
    private Image scoreApple;

    public ScorePanel()
    {
        setBackground(new Color(97, 73, 204));
        setLayout(null);
        loadImages();
        addElements();
    }

    private void loadImages()
    {
        ImageIcon tempApple = new ImageIcon("src/resources/score_apple.png");
        scoreApple = tempApple.getImage().getScaledInstance(Constants.SCORE_APPLE_SIZE, Constants.SCORE_APPLE_SIZE, Image.SCALE_DEFAULT);
    }

    private void addElements()
    {
        JLabel pic = new JLabel(new ImageIcon(scoreApple));
        pic.setBounds(40, 10, Constants.SCORE_APPLE_SIZE, Constants.SCORE_APPLE_SIZE);
        add(pic);

        score = new JLabel("0");
        score.setBounds(100, 13, 80 ,50 );
        score.setFont(new Font("Verdana", Font.BOLD, 40));
        score.setForeground(Color.white);
        add(score);
    }

    public JLabel getScore() { return score; }
}
