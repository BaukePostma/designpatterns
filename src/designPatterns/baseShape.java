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
// 
public abstract class baseShape  implements IComposite {

    // TODO add getters setters
    int x = 50;
    int y = 50;
    int width = 50;
    int height = 50;
boolean isSelected =false;
    int scale = 100;
    String type;

 //   public abstract void Draw(Graphics g);
    
    public  void Accept(Visitor visitor){
        visitor.visit(this);
    }
/**
 * Toggles whether or not this shape is selected 
 */

/**
 *  Scales this shape up or down depending on the position and direction of the mouse drag
 * @param xstart    mouseX starting position
 * @param xend      mouseX end position
 * @param ystart    mouseY start position
 * @param yend      mouseY end position
 */


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

       
         public boolean  isSelected(){
             return this.isSelected;
         }
}

