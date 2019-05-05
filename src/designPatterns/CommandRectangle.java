/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.util.ArrayList;

/**
 *
 * @author Bauke
 */
public class CommandRectangle implements ICommand{
    
    ArrayList<baseShape> shapelist = null;
    baseShape shape = null;
    int x,y,width,height = 0;
    public CommandRectangle(ArrayList<baseShape> shapelist,baseShape q){
        //Hopefully store a reference to the canvas so we can acces the shapelist
        this.shapelist = shapelist;
        this.shape = q;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void Execute() {
      //  Rectangle rect = new Rectangle(x,y,width,height);
        shapelist.add(shape);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Undo() {
        shapelist.remove(shapelist.size()-1);
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
