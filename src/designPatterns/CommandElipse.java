package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for drawing elipses
 * @author Bauke
 */
public class CommandElipse implements ICommand{
    ArrayList<baseShape> shapelist = null;
    baseShape shape = null;
    int x,y,width,height = 0;
    
    /**
     * @param shapelist A reference to the big list of shapes
     * @param q Shape to add to the list
     */
    public CommandElipse(ArrayList<baseShape> shapelist,baseShape q){
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
        shapelist.add(shape);
    }

    @Override
    public void Undo() {
        shapelist.remove(shapelist.size()-1);
    }  
    
}
