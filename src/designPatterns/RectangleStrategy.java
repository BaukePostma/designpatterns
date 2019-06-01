package designPatterns;

import java.awt.Graphics;

/**
 *
 * @author Bauke
 */
public class RectangleStrategy implements IDrawStrategy{
    
  private static RectangleStrategy singleton = new RectangleStrategy();
  
  private RectangleStrategy(){}
  
    @Override
    public void Draw(Graphics g, int x,int y, int width, int height) {
        g.drawRect(x, y, width, height);
    }
    public static  RectangleStrategy GetInstance(){
        return singleton;
}
   
}
