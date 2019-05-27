package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
/**
 *The canvas that holds and draws the shapes. Singleton
 * @author Bauke
 */

public class Canvas extends JPanel {
    private static Canvas singleton = new Canvas();
        private String state = "Rectangle";
    //ArrayList<baseShape> shapeList = new ArrayList();
        
    Group shapeList = new Group();


    private Canvas(){}
    public static Canvas getInstance(){
        return singleton;
    }
    public void setState(String newname) {
        this.state = newname;
    }

    public String getState() {
        return state;
    }

    public void RectangleTest() {
        Rectangle firstRect = new Rectangle(50, 50, 50, 50);
        shapeList.AddShape(firstRect);
    }
/**
 * The main drawing loop. Renders all the shapes in shpeList.
 * @param g magical graphics object
 */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        shapeList.drawShapes(g);
//        for (int i = 0; i < shapeList.size(); i++) {
//            // Draw all the elements in shapeVector
//            shapeList.get(i).SetMinSize();
//            shapeList.get(i).Draw(g);
//            
//        }
        g.drawString("a", 10, 20);
    }
}
