package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern implementation that moves the x and y values in the execute and undo functions
 *
 * @author Bauke
 */
public class CommandDrag implements ICommand {
    ArrayList<baseShape> dragged = null;
    int x;
    int y;
    
    // 
    /**
     * 
     * @param dragged List of all the selected shapes
     * @param x values to move x by
     * @param y values to move y by
     */
    public CommandDrag(ArrayList<baseShape> dragged,int x,int y){
        this.dragged = dragged;
        this.x = x;
        this.y = y;
        
    }

    @Override
    public void Execute() {
          for (baseShape shape : dragged) {
            System.out.println("Old " + shape.x +" "+ shape.y);
            shape.x += x;
            shape.y += y;
          System.out.println("New " + shape.x +" "+ shape.y);
          System.out.println("X movement:" + x+" Y movemement: "+ y);
        }
 
    }

    @Override
    public void Undo() {
        for (baseShape shape : dragged) {
            System.out.println("Old " + shape.x +" "+ shape.y);
            shape.x -= x;
            shape.y -= y;
          System.out.println("New " + shape.x +" "+ shape.y);
           System.out.println("X movement:" + x+" Y movemement: "+ y);
        }
    }
    
}
