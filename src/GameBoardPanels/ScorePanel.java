package GameBoardPanels;

import Constants.Constants;
import GameBoardObjects.TimeDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel
{
    private final TimeDisplay timeDisplay;
    private JLabel score;
    private Image scoreApple;
    private JButton pauseButton;

    public ScorePanel()
    {
        timeDisplay = new TimeDisplay();
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

        timeDisplay.setBounds(400, 13, 150 ,50);
        add(timeDisplay);

        pauseButton = new JButton("<html><p style='font-size:20px; color:black'>Pause</p></html>");
        pauseButton.setBounds(650, 10, 130 ,50);
        pauseButton.setFocusable(false);
        pauseButton.setBackground(new Color(52, 203, 52));
        add(pauseButton);
    }

    public void addActionListenerToPauseButton(ActionListener e)
    {
        pauseButton.addActionListener(e);
    }

    public JLabel getScore() { return score; }
}
