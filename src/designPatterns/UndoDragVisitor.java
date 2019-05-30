/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 *
 * @author Bauke
 */
public class UndoDragVisitor implements Visitor{
    
    int x;
    int y;

    public UndoDragVisitor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void visit(Group group) {

       for (IComposite shape:group.childshapes){
            shape.Accept(this);
        }

    }

    @Override
    public void visit(baseShape shape) {
        dragShapes(shape);

    }

    private void dragShapes(baseShape shape) {

        System.out.println("Old " + shape.x + " " + shape.y);
        shape.x -= x;
        shape.y -= y;
        System.out.println("New " + shape.x + " " + shape.y);
        System.out.println("X movement:" + x + " Y movemement: " + y);
    }
}

