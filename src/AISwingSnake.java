import java.awt.EventQueue;
import javax.swing.JFrame;
import GameBoard.Board;

public class AISwingSnake extends JFrame
{

    public AISwingSnake()
    {
        initUI();
    }

    private void initUI()
    {
        add(new Board());
        setResizable(false);
        pack();

        setTitle("AI Swing Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void runGame()
    {
        EventQueue.invokeLater(() -> {
            JFrame ex = new AISwingSnake();
            ex.setVisible(true);
        });
    }
}