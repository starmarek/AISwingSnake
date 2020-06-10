package GameBoardObjects;

import GameBoardPanels.SnakePanel;
import Snakes.PlayerSnake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapGenerator
{
    private List<BaseBoardObjects> obstacleList;

    public MapGenerator()
    {
        obstacleList = new ArrayList<BaseBoardObjects>();
        generateMap();
    }

    private void generateMap()
    {
        BaseBoardObjects temp = new HorizontalObstacle();
        obstacleList.add(temp);
        for(int i=0; i<2; ++i)
        {
            temp = new VerticalObstacle();
            obstacleList.add(temp);
        }
    }

    public void drawMap(Graphics graphics, SnakePanel board)
    {
        for(BaseBoardObjects obstacle : obstacleList)
            obstacle.draw(graphics, board);
    }

    public List<BaseBoardObjects> getObstaclesList()
    {
        return obstacleList;
    }
}
