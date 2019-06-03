package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * The canvas that holds and draws the shapes. Basically everything below the menu bar
 * Singleton
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
/**
 *  Sets the canvas state. Determines the funcitons to call when clicking across the canvas
 * @param newname New state
 */
    public void setState(String newname) {
        this.state = newname;
    }
/**
 * Returns the state 
 * @return 
 */
    public String getState() {
        return state;
    }

    /**
     * The main drawing loop. Renders all the shapes in shpeList composite. This is where the magical graphics object comes from
     *
     * @param g magical graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapeList.Draw(g);
    }
}
