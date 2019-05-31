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
 * @author Bemi
 */
public class Elipse extends baseShape implements IComposite {

    public Elipse(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = "elipse";
    }

//    public void paintComponent(Graphics g) {
//        System.out.print("IT DRAWS");
//    }
    @Override
    public void drawShapes(Graphics g) {

        g.drawOval(x, y, width, height);
    }

    @Override
    public ArrayList<IComposite> getSelected() {
        ArrayList<IComposite> single = new ArrayList<IComposite>();
        single.add(this);
        return single;
    }

}
