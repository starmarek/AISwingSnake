package Frame;

import Constants.Constants;
import Frame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryScreen extends JPanel implements ActionListener
{
    private Image image;

    public EntryScreen()
    {
        setLayout(null);
        loadImages();
        addElements();
        setBackground(new Color(52, 203, 52));
    }

    private void loadImages()
    {
        ImageIcon tmp = new ImageIcon("src/resources/logo.png");
        image = tmp.getImage().getScaledInstance(Constants.LOGO_SIZE_X, Constants.LOGO_SIZE_Y, Image.SCALE_DEFAULT);
    }

    private void addElements()
    {
        JLabel pic = new JLabel(new ImageIcon(image));
        pic.setBounds(225, 50, Constants.LOGO_SIZE_X, Constants.LOGO_SIZE_Y);
        add(pic);

        JButton start_button = new JButton("<html><p style='font-size:20px; color:white'>Start game</p></html>");
        start_button.setBounds(240, 550, 320, 100);
        start_button.setBackground(new Color(97, 73, 204));
        start_button.setFocusable(false);
        start_button.addActionListener(this);
        add(start_button);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        AISwingSnake.switchToGameBoard();
    }
}
