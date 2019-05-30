package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for creating rectangles
 * @author Bauke
 */
public class CommandRectangle implements ICommand{
    
    Group shapelist ;
    baseShape shape ;
    int x,y,width,height = 0;
    /**
     * 
     * @param shapelist Reference to the shapelist.Add the shape to this
     * @param q  The shape to add
     */
    public CommandRectangle(Group shapelist,baseShape q){
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
        this.shapelist.AddShape(shape);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Undo() {
        shapelist.RemoveShape(shape);
      //  shapelist.RemoveShape(shapelist.size()-1);
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
