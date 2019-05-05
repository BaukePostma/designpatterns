/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;

/**
 * baseShape for all shapes
 *
 * @author Bauke
 * 
 */
public abstract class baseShape {

    // TODO add getters setters
    int x = 50;
    int y = 50;
    int width = 50;
    int height = 50;
    boolean isSelected = false;
    int scale = 100;
    String type;

    public abstract void Draw(Graphics g);
/**
 * Toggles whether or not this shape is selected 
 */
    public void toggleSelection() {

        this.isSelected = !this.isSelected;

    }
/**
 *  Scales this shape up or down depending on the position and direction of the mouse drag
 * @param xstart    mouseX starting position
 * @param xend      mouseX end position
 * @param ystart    mouseY start position
 * @param yend      mouseY end position
 */
    public void Rescale(int xstart, int xend, int ystart, int yend) {

        //    int scalefactor = 1;
        // Get the coordinates of the center of the shape
        int centerx = this.x + (width / 2);
        int centery = this.x + (height / 2);

        int xdiff = xend - xstart;
        int ydiff = yend - ystart;

        // Invert scaling if the movement happend higher and to the left of the shape
        if (xend < centerx) {
            int test = xdiff / 2;
            this.width -= xdiff;
            this.x += test;
        } else {
            int test = xdiff / 2;
            this.width += xdiff;
            this.x -= test;
        }

        if (yend < centery) {
            int testy = ydiff / 2;
            this.height -= ydiff;
            this.y += testy;
        } else {
            int testy = ydiff / 2;
            this.height += ydiff;
            this.y -= testy;
        }

    }

    //Sets a minimum shape for every shape, to make sure it's still visible
    public void SetMinSize() {
        if (this.width < 0) {
            this.width = 5;
        }
        if (this.height < 0) {
            this.height = 5;
        }
    }
    
     public baseShape drawShape(String type, int xpos, int ypos, int xend, int yend) {
        int width = xend - xpos;
        int height = yend - ypos;
        // Draai width & height om zodat ze altijd positief zijn
        if (width < 0) {
            width = width * -1;
        }
        if (height < 0) {
            height = height * -1;
        }
        int lowestX;
        if (xpos < xend) {
            lowestX = xpos;
        } else {
            lowestX = xend;
        }
        int lowestY;
        if (ypos < yend) {
            lowestY = ypos;
        } else {
            lowestY = yend;
        }
        if (type == "circle") {
            Elipse shape = new Elipse(lowestX, lowestY, width, height);
            return shape;
            //mainCanvas.shapeList.add(shape);

        } else  {
            Rectangle shape = new Rectangle(lowestX, lowestY, width, height);
            return shape;
            //mainCanvas.shapeList.add(shape);
        }
    }
}
