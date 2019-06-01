/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Abstract base class for all shapes
 *
 * @author Bauke
 *
 */
// 
public class baseShape implements IComposite {
    // TODO add getters setters

    int x, y, width, height;
    IDrawStrategy DrawStrategy;
    boolean isSelected = false;
    String type;

    public baseShape(int x, int y, int width, int height, IDrawStrategy strat) {
        
       this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.DrawStrategy = strat;
    }

    public void Accept(Visitor visitor) {
        visitor.visit(this);
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

    public boolean isSelected() {
        return this.isSelected;
    }

    public void Draw(Graphics g) {
        this.DrawStrategy.Draw(g, x, y, width, height);
    }

    @Override
    public ArrayList<IComposite> getSelected() {
           ArrayList<IComposite> selected = new ArrayList<IComposite>();
        if (isSelected) {
         selected.add(this);
        }
           return selected;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Takes mouse coordinates, turns them into shape variables
     *
     * @param xpos
     * @param ypos
     * @param xend
     * @param yend
     * @return
     */

}
