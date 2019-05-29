package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for drawing elipses
 * @author Bauke
 */
public class CommandElipse implements ICommand{
Group shapelist ;
    baseShape shape = null;
    int x,y,width,height = 0;
    
    /**
     * @param shapelist A reference to the big list of shapes
     * @param q Shape to add to the list
     */
    public CommandElipse(Group shapelist,baseShape q){
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
        shapelist.RemooveShape(shape);
      //  shapelist.RemoveShape(shapelist.size()-1);
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
