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
public class Group implements ShapeContainer {
    ArrayList<ShapeContainer> childshapes ;

    public Group(){
        this.childshapes = new ArrayList<>();
    }
    
        @Override
    public void drawShapes(Graphics g) {
            for (ShapeContainer shape: childshapes){
                shape.drawShapes(g);
            }
    }
    public void AddShape(ShapeContainer newshape){
        this.childshapes.add(newshape);
    }
    public void toggleSelection(){
        
    }

    @Override
    public ArrayList<ShapeContainer> ReturnSelectedShapes(int x, int y) {
      ArrayList<ShapeContainer> shapelist = new ArrayList<ShapeContainer>() ;
        ArrayList<ShapeContainer> shapelist = this.childshapes.ReturnSelectedShapes(x,y));
              shapelist.add(this.childshapes.ReturnSelectedShapes(x,y));
        

    }
}
