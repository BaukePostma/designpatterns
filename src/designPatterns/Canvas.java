package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * The canvas that holds and draws the shapes. Basically everything below the menu bar
 * Singleton
 *
 * @author Bauke & Demi
 */

public class Canvas extends JPanel {

    //using final so it is read as a constant, Canvas is a singleton because there only is one Canvas.
    private static final Canvas singleton = new Canvas();
    //creating a state for the Canvas and creating the group for the shapes
    private String state;
    Group shapeList = new Group();

    //constructor, is empty
    private Canvas() {
    }

    //returning Canvas as a singleton
    public static Canvas getInstance() {
        return singleton;
    }

    /**
     * Sets the canvas state. 
     * Determines the functions to call when clicking across the canvas
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
     * The main drawing loop. Renders all the shapes in shapeList composite. This
     * is where the magical graphics object comes from
     *
     * @param g magical graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapeList.Draw(g);
    }
}
