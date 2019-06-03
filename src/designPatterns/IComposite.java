/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Composite pattern interface.
 *
 * @author Bauke & Demi
 */
public interface IComposite {

    public void Draw(Graphics g);

    public ArrayList<IComposite> getSelected();

    // accept() is passed the same visitor object
    // but then the method visit() is called using
    // the visitor object. The right version of visit()
    // is called because of method overloading
    void Accept(Visitor visitor);

    boolean isSelected();

}
