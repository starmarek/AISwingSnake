package Frame;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JPanel
{
    private Image ripSnake;

    public GameOverScreen()
    {
        setLayout(null);
        setBackground(Color.black);
        loadImages();
        addElements();
    }

    private void loadImages()
    {
        ImageIcon tempSnake = new ImageIcon("src/resources/RIP.png");
        ripSnake = tempSnake.getImage().getScaledInstance(Constants.RIP_SNAKE_SIZE_X, Constants.RIP_SNAKE_SIZE_Y, Image.SCALE_DEFAULT);
    }

    private void addElements()
    {
        JLabel snake_pic = new JLabel(new ImageIcon(ripSnake));
        snake_pic.setBounds(215, 50, Constants.RIP_SNAKE_SIZE_X, Constants.RIP_SNAKE_SIZE_Y);
        add(snake_pic);

        JButton retry = new JButton("<html><p style='font-size:20px; color:black'>Play again</p></html>");
        retry.setBounds(255, 450, 300 ,100);
        retry.setFocusable(false);
        retry.addActionListener(e -> AISwingSnake.switchToGameBoard());
        retry.setBackground(new Color(52, 203, 52));
        add(retry);

        JButton exit = new JButton("<html><p style='font-size:20px; color:black'>Quit game</p></html>");
        exit.setBounds(255, 570, 300 ,100);
        exit.setFocusable(false);
        exit.addActionListener(e -> System.exit(0));
        exit.setBackground(new Color(52, 203, 52));
        add(exit);
    }
}
