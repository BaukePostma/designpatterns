package designPatterns;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Bauke
 */
public class ElipseStrategy implements IDrawStrategy {
    
  private static ElipseStrategy singleton = new ElipseStrategy();
  
  private ElipseStrategy(){}
  
    @Override
    public void Draw(Graphics g, int x,int y, int width, int height) {
        g.drawOval(x, y, width, height);
    }
    public static  ElipseStrategy GetInstance(){
        return singleton;
}
   


}
