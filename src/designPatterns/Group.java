package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Composite element of the Composite pattern.
 * @author Bauke
 */
public class Group implements IComposite {
    ArrayList<IComposite> childshapes;
    boolean isSelected;

    public Group() {
        this.childshapes = new ArrayList<>();
        this.isSelected = false;
    }
    
/**
 * Gets called from the Canvas object when  Java decides it's time to update the canvas. 
 * @param g Magical graphics object
 */

    public void Draw(Graphics g) {
        for (IComposite shape : childshapes) {
            shape.Draw(g);
        }
    }
/**
 * Add a composite to this group
 * @param newshape 
 */
    public void AddShape(IComposite newshape) {
        this.childshapes.add(newshape);
    }

    /**
     * Remove a specific component from this group
     * @param newshape 
     */
    public void RemoveShape(IComposite newshape) {
        this.childshapes.remove(newshape);
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public boolean isSelected() {
        return this.isSelected;
    }
/**
 * Returns a list of all the  nodes that are selected
 * @return Groups and shapes
 */
    @Override
    public ArrayList<IComposite> getSelected() {
        ArrayList<IComposite> groupselected = new ArrayList<IComposite>();
        for (IComposite shape : childshapes) {
            if (shape.isSelected()) {
                groupselected.addAll(shape.getSelected());
            }

        }
        return groupselected;
    }
}
