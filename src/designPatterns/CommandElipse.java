package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for drawing elipses
 *
 * @author Bauke
 */
public class CommandElipse implements ICommand {

    Group shapelist;
    baseShape shape = null;
    int x, y, width, height = 0;

    /**
     * @param shapelist A reference to the big list of shapes
     * @param q Shape to add to the list
     */
    public CommandElipse(Group shapelist,int xpos,int ypos,int xend, int yend) {
        //Hopefully store a reference to the canvas so we can acces the shapelist
        this.shapelist = shapelist;
                this.x = xpos;
        this.y = ypos;
       // this.shape = q;
      //  this.x = x;
      //  this.y = y;
     //   this.width = width;
      //  this.height = height;
      CalculateShape(xpos ,ypos ,xend ,yend );
    
      
      this.shape = new baseShape(x,y,width,height,ElipseStrategy.GetInstance());
    }

    @Override
    public void Execute() {
        this.shapelist.AddShape(shape);
    }

    @Override
    public void Undo() {
        shapelist.RemoveShape(shape);
    }
     void CalculateShape(int xpos, int ypos, int xend, int yend) {

        width = xend - xpos;
        height = yend - ypos;
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
    }

}
