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
public class DragVisitor implements Visitor {

    int x;
    int y;

    public DragVisitor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void visit(Group group) {
        System.out.println("Dragvisitor group called");

                  for (IComposite shape:group.childshapes){
            shape.Accept(this);
        }
        //group.Accept(this);
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(baseShape shape) {
        System.out.println("Dragvisitor shape called");
        dragShapes(shape);

    }

    private void dragShapes(baseShape shape) {

        System.out.println("Old " + shape.x + " " + shape.y);
        shape.x += x;
        shape.y += y;
        System.out.println("New " + shape.x + " " + shape.y);
        System.out.println("X movement:" + x + " Y movemement: " + y);
    }
}
