package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern to scale the shapes
 *
 * @author Bauke
 */
public class CommandScale implements ICommand {

    Group shapelist;
    baseShape shape;
    int xstart, xend, ystart, yend;
    int length;
    int origx[], origy[], origwidth[], origheight[]; // Store the original values before scaling, to 'reset' them in the undo 
    ArrayList<baseShape> selectedShapes; // Store references to the shapes that are going to be scaled

    /**
     * @param shapelist A list of the selected shapes to scale
     * @param xstart the x-coordinate of the start of the drag
     * @param xend the x-coordinate of the end of the drag
     * @param ystart the y-coordinate of the start of the drag
     * @param yend the y-coordinate of the end of the drag
     */
    public CommandScale(Group shapelist, int xstart, int xend, int ystart, int yend) {
        this.shapelist = shapelist;
        this.xstart = xstart;
        this.xend = xend;
        this.ystart = ystart;
        this.yend = yend;

        // Get all the Composites  that are selected. Get   a new list of concrete baseShapes that are going to be scaled. 
        ArrayList<IComposite> selected = shapelist.getSelected();
        selectedShapes = new ArrayList<baseShape>();
        for (IComposite item : selected) {
            if (item instanceof baseShape) {
                selectedShapes.add((baseShape) item);
            }
        }

        this.length = selected.size();
        //Store the original baseShape values before scaling  to Undo them later
        this.origx = new int[length];
        this.origy = new int[length];
        this.origwidth = new int[length];
        this.origheight = new int[length];

        for (int i = 0; i < length; i++) {
            origx[i] = selectedShapes.get(i).x;
            origy[i] = selectedShapes.get(i).y;
            origwidth[i] = selectedShapes.get(i).width;
            origheight[i] = selectedShapes.get(i).height;

        }
//        System.out.print(" ");
    }

    @Override
    public void Execute() {
        ScaleVisitor visitor = new ScaleVisitor(xstart, xend, ystart, yend);
        shapelist.Accept(visitor);
    }

    @Override
    public void Undo() {
        //UndoScaleVisitor visitor = new UndoScaleVisitor(x, y);
        // selected.Accept(visitor);

        for (int i = 0; i < length; i++) {
            selectedShapes.get(i).x = origx[i];
            selectedShapes.get(i).y = origy[i];
            selectedShapes.get(i).width = origwidth[i];
            selectedShapes.get(i).height = origheight[i];

        }

        System.out.print(" ");
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
