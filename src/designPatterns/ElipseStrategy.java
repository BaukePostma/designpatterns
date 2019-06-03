package designPatterns;

import java.awt.Graphics;

/**
 * Strategy pattern for ellipse
 *
 * @author Bauke & Demi
 */
public class ElipseStrategy implements IDrawStrategy {
    //creating singleton for elipse strategy, because there's only one

    private static final ElipseStrategy singleton = new ElipseStrategy();

    //empty constructor
    private ElipseStrategy() {
    }

    //draw function for ellipse
    //override from IDrawStrategyy interface
    @Override
    public void Draw(Graphics g, int x, int y, int width, int height) {
        g.drawOval(x, y, width, height);
    }

    //returning singleton object
    public static ElipseStrategy GetInstance() {
        return singleton;
    }

}
