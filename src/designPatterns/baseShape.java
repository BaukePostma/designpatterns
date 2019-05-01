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
 */
public abstract class baseShape {

    // TODO add getters setters
    int x = 50;
    int y = 50;
    int width = 50;
    int height = 50;
    boolean isSelected = false;
    int scale = 100;

    public abstract void Draw(Graphics g);

    public void toggleSelection() {

        this.isSelected = !this.isSelected;

    }

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
        //Test
//        double test1 = width - xdiff;
//        double test2 = centerx - width;
//        double test3 = test1 / test2;
//        // double Xvar = ((width-xdiff) / (centerx-width));
//        double ScaleX = test3 + 1;
//        //end test
//        int test = xdiff / 2;
//        this.width += xdiff;
//        this.x -= test;
//
//        int testy = ydiff / 2;
//        this.height += ydiff;
//        this.y -= testy;

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
}
