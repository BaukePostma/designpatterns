package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * The canvas that holds and draws the shapes. Singleton
 *
 * @author Bauke
 */

public class Canvas extends JPanel {

    private static Canvas singleton = new Canvas();
    private String state;
    Group shapeList = new Group();

    private Canvas() {
    }

    public static Canvas getInstance() {
        return singleton;
    }

    public void setState(String newname) {
        this.state = newname;
    }

    public String getState() {
        return state;
    }

    /**
     * The main drawing loop. Renders all the shapes in shpeList composite.
     *
     * @param g magical graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapeList.drawShapes(g);
    }
}
