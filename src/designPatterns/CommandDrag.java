package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern implementation that moves the x and y values in the execute
 * and undo functions
 *
 * @author Bauke
 */
public class CommandDrag implements ICommand {

    Group dragged;
    int x;
    int y;

    /**
     * @param dragged List of all the selected shapes
     * @param x values to move x by
     * @param y values to move y by
     */
    public CommandDrag(Group dragged, int x, int y) {
        this.dragged = dragged;
        this.x = x;
        this.y = y;
    }

    @Override
    public void Execute() {
        DragVisitor visitor = new DragVisitor(x, y);
        dragged.Accept(visitor);

    }

    @Override
    public void Undo() {
        UndoDragVisitor visitor = new UndoDragVisitor(x, y);
        dragged.Accept(visitor);
    }
}
