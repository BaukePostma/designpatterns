package designPatterns;

import java.awt.Graphics;

/**
 * Strategy pattern for ellipse
 *
 * @author Bauke & Demi
 */
public class RectangleStrategy implements IDrawStrategy {

    //creating singleton for rectangle strategy, because there's only one
    private static RectangleStrategy singleton = new RectangleStrategy();

    //empty constructor
    private RectangleStrategy() {
    }

    //draw function for rectangle
    //override from IDrawStrategyy interface
    @Override
    public void Draw(Graphics g, int x, int y, int width, int height) {
        g.drawRect(x, y, width, height);
    }

    //returning singleton object
    public static RectangleStrategy GetInstance() {
        return singleton;
    }

}
