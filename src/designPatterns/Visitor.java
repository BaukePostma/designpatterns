/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 * Base visitor interface
 *
 * @author Bauke & Demi
 */
public interface Visitor {

    //creating instances that can be edited using the visitor pattern
    public void visit(Group group);

    public void visit(baseShape shape);

}
