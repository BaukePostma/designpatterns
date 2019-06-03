package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for creating rectangles
 *
 * @author Bauke & Demi
 */
public class CommandRectangle implements ICommand {

    //list of shapes, setting the shapes to empty, creating vars for coördinates and size
    Group shapelist;
    baseShape shape;
    int x, y, width, height;

    /**
     * @param shapelist A reference to the big list of shapes
     * @param xpos position on x-axis
     * @param ypos position on y-axis
     * @param xend ending pos of x-axis
     * @param yend ending pos of y-axis
     */
    public CommandRectangle(Group shapelist, int xpos, int ypos, int xend, int yend) {
        //Hopefully store a reference to the canvas so we can acces the shapelist
        this.shapelist = shapelist;
        this.x = xpos;
        this.y = ypos;
        CalculateShape(xpos, ypos, xend, yend);

        this.shape = new baseShape(x, y, width, height, RectangleStrategy.GetInstance());
    }

    //making shape in shapelist drawable
    @Override
    public void Execute() {

        this.shapelist.AddShape(shape);
    }

    //making shape in shapelist removable
    @Override
    public void Undo() {
        shapelist.RemoveShape(shape);
    }

    //function to calculate the size of elipse
    void CalculateShape(int xpos, int ypos, int xend, int yend) {

        //width is the beginning of x-axis minus end of x-axis
        //height is the beginning of y-axis mines end of y-axis
        width = xend - xpos;
        height = yend - ypos;
        
        //if width / height are negative vals, make them positive so position is right
        if (width < 0) {
            width = width * -1;
        }
        if (height < 0) {
            height = height * -1;
        }
        
        int lowestX;
        //if beginning of x is smaller than ending
        if (xpos < xend) {
            //set lowest x value to the beginning
            lowestX = xpos;
        } else {
            //else, lowest x value is the ending of x
            lowestX = xend;
        }
        
        int lowestY;
        //if beginning of y is smaller than ending
        if (ypos < yend) {
            //set lowest y value to the beginning
            lowestY = ypos;
        } else {
            //else, lowest y value is the ending of y
            lowestY = yend;
        }
    }

}
