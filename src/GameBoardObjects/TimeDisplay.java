package GameBoardObjects;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TimeDisplay extends JLabel
{
    static Timer timer;
    static long startTime;
    static long pauseTime;

    public TimeDisplay()
    {
        timer = new Timer(1000, e -> setText(String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - startTime),
                TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - startTime)
                ))));
        initLabel();
    }

    private void initLabel()
    {
        setText("00:00");
        setFont(new Font("Verdana", Font.BOLD, 40));
        setForeground(Color.white);
    }

    public static void startCountDown(boolean resume)
    {
        if (!resume)
            startTime = System.currentTimeMillis();
        else
            startTime = startTime + (System.currentTimeMillis() - pauseTime);
        timer.start();
    }

    public static void stopCountDown()
    {
        pauseTime = System.currentTimeMillis();
        timer.stop();
    }
}
