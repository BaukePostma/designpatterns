/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 * Visitor for undoing drags
 * 
 * @author Bauke & Demi
 */
public class UndoDragVisitor implements Visitor {
    //vars
    int x;
    int y;

    //constructor, initializing vars
    public UndoDragVisitor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //visitor for passing selected shape to visitor
    @Override
    public void visit(Group group) {

        group.childshapes.stream().filter((shape) -> (shape.isSelected())).forEachOrdered((shape) -> {
            shape.Accept(this);
        });
    }

    //adding shape to dragged shapes
    @Override
    public void visit(baseShape shape) {
        dragShapes(shape);
    }

    //function for printing old and new pos and movement of shapes
    private void dragShapes(baseShape shape) {
        System.out.println("Old " + shape.x + " " + shape.y + "\n");
        shape.x -= x;
        shape.y -= y;
        System.out.println("New " + shape.x + " " + shape.y + "\n");
        System.out.println("X movement:" + x + " Y movemement: " + y + "\n");
    }
}
