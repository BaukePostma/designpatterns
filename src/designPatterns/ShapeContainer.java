/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bauke
 */
public interface ShapeContainer {

    void drawShapes(Graphics g);

    public void toggleSelection();
    

    public  ArrayList<ShapeContainer> ReturnSelectedShapes (int x, int y)  ;
}
