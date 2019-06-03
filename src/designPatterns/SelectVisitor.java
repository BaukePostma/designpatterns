/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 * Handles the toggling of the select boolean of the various groups and shapes
 *
 * @author Bauke & Demi
 */
public class SelectVisitor implements Visitor {
    //vars
    int MouseX;
    int MouseY;

    //constructor, intitializing vars
    public SelectVisitor(int xpos, int ypos) {
        this.MouseX = xpos;
        this.MouseY = ypos;
    }

    //function for passing shape to visitor
    @Override
    public void visit(Group group) {
        for (IComposite shape : group.childshapes) {
            boolean orginalselectionstate = shape.isSelected();

            shape.Accept(this);
            
            if (shape.isSelected() != orginalselectionstate) {
                //the shape selection has been toggled, toggle this group as well
                group.isSelected = !group.isSelected;
            }
        }

        System.out.println("Group status: " + group.isSelected + "\n");

    }

    //function for setting shape to not selected if mouse is clicked elsewhere
    @Override
    public void visit(baseShape shape) {
        if (pointCheck(MouseX, MouseY, shape)) {
            shape.isSelected = !shape.isSelected;
        }
    }

    /**
     * Check if a mouse coordinate falls within the boundaries of a shape. Used
     * for selecting
     */
    boolean pointCheck(int mouseX, int mouseY, baseShape testshape) {

        if (mouseX > testshape.x && mouseX < testshape.x + testshape.width
                && mouseY > testshape.y && mouseY < testshape.y + testshape.height) {
            System.out.println("Selected a shape");
            return true;
        }
        return false;
    }
}
