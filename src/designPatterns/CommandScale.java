package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern to scale the shapes
 *
 * @author Bauke
 */
public class CommandScale implements ICommand {

    Group scaled;
    baseShape shape;
    int xstart, xend, ystart, yend;
    int length;
    int origx[], origy[], origwidth[], origheight[]; // Store the original values before scaling, to 'reset' them in the undo 

    /**
     * @param scaled A list of the selected shapes to scale
     * @param xstart the x-coordinate of the start of the drag
     * @param xend the x-coordinate of the end of the drag
     * @param ystart the y-coordinate of the start of the drag
     * @param yend the y-coordinate of the end of the drag
     */
    public CommandScale(Group scaled, int xstart, int xend, int ystart, int yend) {
        //Hopefully store a reference to the canvas so we can acces the shapelist
        this.scaled = scaled;
        this.xstart = xstart;
        this.xend = xend;
        this.ystart = ystart;
        this.yend = yend;

        //  this.length = scaled.size();
       //  Store the original values before scaling , for use in the Undo
//        this.origx = new int[length];
//        this.origy = new int[length];
//        this.origwidth = new int[length];
//        this.origheight = new int[length];     
//        for (int i = 0; i < length; i++) {
//            origx[i] = scaled.get(i).x;
//            origy[i] = scaled.get(i).y;
//            origwidth[i] = scaled.get(i).width;
//            origheight[i] = scaled.get(i).height;
            
//        }
//        System.out.print(" ");
    }

    @Override
    public void Execute() {
        //  Rectangle rect = new Rectangle(x,y,width,height);
//        for (baseShape shape : scaled) {
//            shape.Rescale(xstart, xend, ystart, yend);
//        }
        ScaleVisitor visitor = new ScaleVisitor(xstart, xend, ystart, yend);
        scaled.Accept(visitor);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Undo() {
//       UndoScaleVisitor visitor = new UndoScaleVisitor(x, y);
//        scaled.Accept(visitor);
//
//        for (int i = 0; i < length; i++) {
//            scaled.get(i).x = origx[i];
//            scaled.get(i).y = origy[i];
//            scaled.get(i).width = origwidth[i];
//            scaled.get(i).height = origheight[i];
//
//        }
//
//        System.out.print(" ");
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
