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
public class Rectangle extends baseShape{

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = "Rectangle";
    }

    /**
     *  Overrride the draw function, geps passed the graphics object, calls the draw function to draw itself
     * @param g Magical graphics object
     */
    @Override
    public void Draw(Graphics g) {
        //       super.paintComponent(g);
        // Retrieve the graphics context; this object is used to paint shapes
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x, y, width, height);
        //  g2d.scale(5, 5);
    }

    @Override
    public void drawShapes(Graphics g) {
        g.drawRect(x, y, width, height);
    }
        @Override
    public void toggleSelection() {
        this.isSelected = !this.isSelected;
    }

    @Override
    public ArrayList<ShapeContainer> ReturnSelectedShapes(int x, int y) {
        ArrayList<ShapeContainer> single = new ArrayList<ShapeContainer>();
        if (this.isSelected) {
            single.add(this);
        }
        return single;
    }

}
