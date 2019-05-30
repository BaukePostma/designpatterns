/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Composite pattern interface. Rename this?
 * @author Bauke
 */
public interface IComposite {

    void drawShapes(Graphics g);
    public ArrayList<IComposite> getSelected();

    void Accept(Visitor visitor);
    boolean isSelected();
   // public void toggleSelection();
 
}
