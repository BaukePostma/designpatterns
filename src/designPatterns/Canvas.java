package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
/**
 *The canvas that holds and draws the shapes. 
 * @author Bauke
 */

public class Canvas extends JPanel {

    ArrayList<baseShape> shapeList = new ArrayList();
    private String state = "Rectangle";

    public void setState(String newname) {
        this.state = newname;
    }

    public String getState() {
        return state;
    }

    public Canvas() {
        Rectangle firstRect = new Rectangle(50, 50, 50, 50);
        shapeList.add(firstRect);
    }
/**
 * The main drawing loop. Renders all the shapes in shpeList.
 * @param g magical graphics object
 */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < shapeList.size(); i++) {
            // Draw all the elements in shapeVector
            shapeList.get(i).SetMinSize();
            shapeList.get(i).Draw(g);
            
        }
        g.drawString("a", 10, 20);
    }
}
