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
    public CommandElipse(Group shapelist, baseShape q) {
        this.shapelist = shapelist;
        this.shape = q;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void Execute() {
        this.shapelist.AddShape(shape);
    }

    @Override
    public void Undo() {
        shapelist.RemoveShape(shape);
    }

}
