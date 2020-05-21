package GameBoard;

import java.awt.*;
import javax.swing.JPanel;

import Constants.*;

public class Board extends JPanel {

    private final GridBagConstraints gbc;
    private final JPanel score_panel;
    private final SnakePanel snake_panel;
    GridBagLayout layout;

    public Board()
    {
        layout = new GridBagLayout();
        score_panel = new JPanel();
        snake_panel = new SnakePanel();
        gbc = new GridBagConstraints();
        setLayout(layout);
        initScorePanel();
        initSnakePanel();
    }

    private void initScorePanel()
    {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.ipady = Constants.SCORE_PANEL_PADDING_HEIGHT;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        score_panel.setBackground(new Color(97, 73, 204));
        add(score_panel, gbc);
    }

    private void initSnakePanel()
    {
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        snake_panel.setBackground(Color.black);
        add(snake_panel, gbc);
        snake_panel.initGame();
    }

    public void requestFocusInSnakePanel()
    {
        snake_panel.requestFocusInWindow();
    }
}