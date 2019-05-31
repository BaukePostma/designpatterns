/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * base Rectangle shape
 *
 * @author Bauke
 */
public class Rectangle extends baseShape {

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = "rectangle";
    }

    /**
     * Overrride the draw function, gets passed the graphics object, calls the
     *  draw function to draw itself
     *
     * @param g Magical graphics object
     */

    @Override
    public void drawShapes(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    @Override
    public ArrayList<IComposite> getSelected() {

        ArrayList<IComposite> single = new ArrayList<IComposite>();
        single.add(this);
        return single;
    }

}
