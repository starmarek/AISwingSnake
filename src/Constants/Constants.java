package Constants;

public final class Constants
{
    private Constants() { }

    public static final int B_WIDTH = 800;
    public static final int B_HEIGHT = 800;
    public static final int DELAY = 100;
    public static final int DOT_SIZE = 10;
    public static final int FRUIT_SIZE = 10;
    public static final int INITIAL_SNAKE_LENGTH = 3;
    public static final int SCORE_PANEL_HEIGHT = (((B_HEIGHT / 11) + 5) / 10) * 10; // (B_HEIGHT / 11) rounded to 10
    public static final int RAND_POS_FRUIT_Y = ((B_HEIGHT - SCORE_PANEL_HEIGHT) / FRUIT_SIZE);
    public static final int RAND_POS_FRUIT_X = B_WIDTH / FRUIT_SIZE;
    public static final int LOGO_SIZE_Y = 350;
    public static final int LOGO_SIZE_X = 350;
    public static final int SCORE_APPLE_SIZE = 50;
    public static final int HINT_ARROWS_SIZE_X = 150;
    public static final int HINT_ARROWS_SIZE_Y = 100;
    public static final int RIP_SNAKE_SIZE_Y = 275;
    public static final int RIP_SNAKE_SIZE_X = 375;
}