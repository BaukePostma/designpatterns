package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern to scale the shapes
 *
 * @author Bauke & Demi
 */
public class CommandScale implements ICommand {

    //making the group and shape, vars for scaling
    Group shapelist;
    baseShape shape;
    int xstart, xend, ystart, yend;
    int length;
    //store the original values before scaling, to 'reset' them in the undo
    int origx[], origy[], origwidth[], origheight[]; 
    //store references to the shapes that are going to be scaled
    ArrayList<baseShape> selectedShapes;

    /**
     * @param shapelist A list of the selected shapes to scale
     * @param xstart the x-coordinate of the start of the drag
     * @param xend the x-coordinate of the end of the drag
     * @param ystart the y-coordinate of the start of the drag
     * @param yend the y-coordinate of the end of the drag
     */
    //constructor, initializing vars
    public CommandScale(Group shapelist, int xstart, int xend, int ystart, int yend) {
        this.shapelist = shapelist;
        this.xstart = xstart;
        this.xend = xend;
        this.ystart = ystart;
        this.yend = yend;

        //get all the Composites that are selected, t a new list of concrete baseShapes that are going to be scaled. 
        ArrayList<IComposite> selected = shapelist.getSelected();
        selectedShapes = new ArrayList<baseShape>();
        //for all the composite items that are selected
        for (IComposite item : selected) {
            //if item is a shape
            if (item instanceof baseShape) {
                //add shape to the selected shapes list
                selectedShapes.add((baseShape) item);
            }
        }

        this.length = selected.size();
        //store the original baseShape values before scaling to Undo them later
        this.origx = new int[length];
        this.origy = new int[length];
        this.origwidth = new int[length];
        this.origheight = new int[length];

        //getting size of the shapes that are selected
        for (int i = 0; i < length; i++) {
            origx[i] = selectedShapes.get(i).x;
            origy[i] = selectedShapes.get(i).y;
            origwidth[i] = selectedShapes.get(i).width;
            origheight[i] = selectedShapes.get(i).height;

        }
    }

    //making shape in shapelist drawable
    @Override
    public void Execute() {
        ScaleVisitor visitor = new ScaleVisitor(xstart, xend, ystart, yend);
        shapelist.Accept(visitor);
    }
    
    //making shape in shapelist removable
    @Override
    public void Undo() {
        for (int i = 0; i < length; i++) {
            selectedShapes.get(i).x = origx[i];
            selectedShapes.get(i).y = origy[i];
            selectedShapes.get(i).width = origwidth[i];
            selectedShapes.get(i).height = origheight[i];
        }
        System.out.print(" ");
    }
}
