/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.io.PrintWriter;

/**
 * Visitor pattern for saving
 *
 * @author Bauke & Demi
 */
public class SaveVisitor implements Visitor {

    //vars
    PrintWriter pw;
    String tabstring;

    //constructor, initializing vars
    public SaveVisitor(PrintWriter pw) {
        this.pw = pw;
        this.tabstring = "";
    }

    //visitor function to print number of shapes and return them
    //also 
    @Override
    public void visit(Group group) {

        pw.println("group " + getConcreteShapeCount(group));
        tabstring = tabstring + "\t";
        group.childshapes.stream().map((shape) -> {
            pw.print(tabstring);
            return shape;
        }).forEachOrdered((shape) -> {
            //passing shape 
            shape.Accept(this);
        });

    }

    @Override
    public void visit(baseShape shape) {

        String type = new String();
        if (shape.DrawStrategy instanceof RectangleStrategy) {
            type = "rectangle";
        } else {
            type = "ellipse";
        }

        pw.println(
                type + " "
                + shape.x + " "
                + shape.y + " "
                + shape.width + " "
                + shape.height + " "
        );

    }

    //function to get the amount of shapes in a group
    private int getConcreteShapeCount(Group comp) {
        int compcount = 0;

        for (IComposite item : comp.childshapes) {
            if (item instanceof baseShape) {
                compcount++;
            }
        }
        return compcount;
    }

}
