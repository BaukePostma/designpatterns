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
 * @author Bauke & Demi
 *
 */
public class baseShape implements IComposite {
    int x, y, width, height;
    IDrawStrategy DrawStrategy;
    boolean isSelected = false;
    String type;
    
    //constructor, initializing vars
    public baseShape(int x, int y, int width, int height, IDrawStrategy strat) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.DrawStrategy = strat;
    }

    //accept function from visitor
    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }

    //sets a minimum shape for every shape, to make sure it's still visible
    public void SetMinSize() {
        if (this.width < 0) {
            this.width = 5;
        }
        if (this.height < 0) {
            this.height = 5;
        }
    }

    //overrided select function
    @Override
    public boolean isSelected() {
        return this.isSelected;
    }

    //overrides draw function
    @Override
    public void Draw(Graphics g) {
        this.DrawStrategy.Draw(g, x, y, width, height);
    }

    //function for getting selected shapes and adding them to a list
    @Override
    public ArrayList<IComposite> getSelected() {
        ArrayList<IComposite> selected = new ArrayList<>();
        if (isSelected) {
            selected.add(this);
        }
        return selected;
    }
}
