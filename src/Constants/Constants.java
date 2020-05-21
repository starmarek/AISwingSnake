package Constants;

public final class Constants
{
    private Constants() { }

    public static final int B_WIDTH = 800;
    public static final int B_HEIGHT = 800;
    public static final int DELAY = 150;
    public static final int DOT_SIZE = 10;
    public static final int FRUIT_SIZE = 10;
    public static final int INITIAL_SNAKE_LENGTH = 3;
    public static final int SCORE_PANEL_PADDING_HEIGHT = (((B_HEIGHT / 15) + 5) / 10) * 10; // (B_HEIGHT / 15) rounded to 10

    // JPanel object (score panel) has a base height of 10px. Because of that,
    // actual height after padding added will be greater by 10px.
    public static final int SCORE_PANEL_HEIGHT = SCORE_PANEL_PADDING_HEIGHT + 10;
    public static final int RAND_POS_FRUIT_Y = ((B_HEIGHT - SCORE_PANEL_HEIGHT) / FRUIT_SIZE);
    public static final int RAND_POS_FRUIT_X = B_WIDTH / FRUIT_SIZE;
    public static final int LOGO_SIZE_Y = 350;
    public static final int LOGO_SIZE_X = 350;
}