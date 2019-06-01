package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for creating rectangles
 *
 * @author Bauke
 */
public class CommandRectangle implements ICommand {

    Group shapelist;
    baseShape shape;
    int x, y, width, height;

    /**
     *
     * @param shapelist Reference to the shapelist.Add the shape to this
     * @param q The shape to add
     */
    public CommandRectangle(Group shapelist, int xpos, int ypos, int xend, int yend) {
        //Hopefully store a reference to the canvas so we can acces the shapelist
        this.shapelist = shapelist;
        this.x = xpos;
        this.y = ypos;
        CalculateShape(xpos, ypos, xend, yend);

        this.shape = new baseShape(x, y, width, height, RectangleStrategy.GetInstance());
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
