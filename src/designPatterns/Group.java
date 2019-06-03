package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Composite element of the Composite pattern.
 *
 * @author Bauke & Demi
 */
public class Group implements IComposite {
    //composite list of childshapes
    ArrayList<IComposite> childshapes;
    boolean isSelected;

    //constructor, initializing vars
    public Group() {
        this.childshapes = new ArrayList<>();
        this.isSelected = false;
    }

    /**
     * Gets called from the Canvas object when Java decides it's time to update
     * the canvas.
     *
     * @param g Magical graphics object
     */
    @Override
    public void Draw(Graphics g) {
        //draw shape for each shape in childshapes list
        childshapes.forEach((shape) -> {
            shape.Draw(g);
        });
    }

    /**
     * Add a composite to this group
     *
     * @param newshape
     */
    public void AddShape(IComposite newshape) {
        this.childshapes.add(newshape);
    }

    /**
     * Remove a specific component from this group
     *
     * @param newshape
     */
    public void RemoveShape(IComposite newshape) {
        this.childshapes.remove(newshape);
    }

    //acception function from visitor
    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }

    //returning selected state
    @Override
    public boolean isSelected() {
        return this.isSelected;
    }

    /**
     * Returns a list of all the nodes that are selected
     *
     * @return Groups and shapes
     */
    @Override
    public ArrayList<IComposite> getSelected() {
        ArrayList<IComposite> groupselected = new ArrayList<>();
        for (IComposite shape : childshapes) {
            if (shape.isSelected()) {
                groupselected.addAll(shape.getSelected());
            }

        }
        return groupselected;
    }
}
