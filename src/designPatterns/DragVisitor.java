/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 * Visitor class for dragging
 *
 * @author Bauke & Demi
 */
public class DragVisitor implements Visitor {

    int x;
    int y;

    //constructor, initializing vars
    public DragVisitor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //function for 
    @Override
    public void visit(Group group) {
        System.out.println("Dragvisitor group called\n");
        //visitor object goes through every existing shape / group and gives itself child elements
        group.childshapes.stream().filter((shape) -> (shape.isSelected())).forEachOrdered((shape) -> {
            shape.Accept(this);
        });
    }

    //visitor for dragable shapes
    @Override
    public void visit(baseShape shape) {
        System.out.println("Dragvisitor shape called\n");
        dragShapes(shape);
    }

    //printing old and new position of shapes + how much they moved
    private void dragShapes(baseShape shape) {
        System.out.println("Old " + shape.x + " " + shape.y + "\n");
        shape.x += x;
        shape.y += y;
        System.out.println("New " + shape.x + " " + shape.y + "\n");
        System.out.println("X movement:" + x + " Y movemement: " + y + "\n");
    }
}
