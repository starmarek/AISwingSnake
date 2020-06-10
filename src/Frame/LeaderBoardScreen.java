package Frame;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderBoardScreen extends JPanel
{
    private Image trophy;
    private final ArrayList<ArrayList<String>> leaderBoard;

    public LeaderBoardScreen()
    {
        leaderBoard = AISwingSnake.getLeaderBoard();
        setLayout(null);
        setBackground(Color.black);
        loadImages();
        addElements();
    }

    private void loadImages()
    {
        ImageIcon tmp = new ImageIcon("src/resources/trophy.png");
        trophy = tmp.getImage().getScaledInstance(Constants.TROPHY_SIZE_X, Constants.TROPHY_SIZE_Y, Image.SCALE_DEFAULT);
    }

    private void addElements()
    {
        JLabel pic = new JLabel(new ImageIcon(trophy));
        pic.setBounds(30, 300, Constants.TROPHY_SIZE_X, Constants.TROPHY_SIZE_Y);
        add(pic);

        JLabel info_text = new JLabel("Best players");
        info_text.setForeground(Color.yellow);
        info_text.setFont(new Font("Verdana", Font.BOLD, 85));
        info_text.setBounds(100, 55, 750, 100);
        add(info_text);

        for (int i = 0; i < leaderBoard.size(); ++i)
        {
            JLabel player = new JLabel(leaderBoard.get(i).get(0));
            player.setForeground(Color.green);
            player.setFont(new Font("Verdana", Font.BOLD, 40));
            player.setBounds(310, 210 + 60 * i, 400, 150);
            add(player);

            JLabel scr = new JLabel(leaderBoard.get(i).get(1));
            scr.setForeground(Color.green);
            scr.setFont(new Font("Verdana", Font.BOLD, 40));
            scr.setBounds(710, 210 + 60 * i, 150, 150);
            add(scr);
        }

        JButton start_button = new JButton("<html><p style='font-size:20px; color:white'>Go back</p></html>");
        start_button.setBounds(240, 625, 320, 100);
        start_button.setBackground(new Color(97, 73, 204));
        start_button.setFocusable(false);
        start_button.addActionListener(e -> AISwingSnake.switchToGameOverScreen());
        add(start_button);
    }
}
