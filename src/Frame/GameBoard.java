package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

import GameBoardPanels.ScorePanel;
import GameBoardPanels.SnakePanel;
import Constants.*;

public class GameBoard extends JPanel {

    private final GridBagConstraints gbc;
    private final ScorePanel score_panel;
    private final SnakePanel snake_panel;

    public GameBoard()
    {
        score_panel = new ScorePanel();
        snake_panel = new SnakePanel();
        gbc = new GridBagConstraints();
        snake_panel.addSnakeObjectPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                score_panel.getScore().setText(String.valueOf(snake_panel.getScore()));
            }
        });
        setLayout(new GridBagLayout());
        initScorePanel();
        initSnakePanel();
    }

    private void initScorePanel()
    {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.ipady = Constants.SCORE_PANEL_HEIGHT;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        score_panel.addActionListenerToPauseButton(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                snake_panel.pauseGame();
            }
        });
        add(score_panel, gbc);
    }

    private void initSnakePanel()
    {
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(snake_panel, gbc);

        snake_panel.initStartAdapter();
    }

    public void requestFocusInSnakePanel()
    {
        snake_panel.requestFocusInWindow();
    }
}