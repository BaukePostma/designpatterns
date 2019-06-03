package designPatterns;

/**
 * ScaleVisitor handles the scaling of groups and objects
 *
 * @author Bauke & Demi
 */
public class ScaleVisitor implements Visitor {

    //vars
    int xstart;
    int xend;
    int ystart;
    int yend;

    //constructor, initializing vars
    public ScaleVisitor(int xstart, int xend, int ystart, int yend) {
        this.xstart = xstart;
        this.xend = xend;
        this.ystart = ystart;
        this.yend = yend;
    }

    //function for passing selected shapes to visitor
    @Override
    public void visit(Group group) {
        group.childshapes.stream().filter((shape) -> (shape.isSelected())).forEachOrdered((shape) -> {
            shape.Accept(this);
        });
    }

    @Override
    public void visit(baseShape shape) {
        //scale this shape
        Rescale(shape, xstart, xend, ystart, yend);
    }

    /**
     * Handles the rescale calculations depending on mouse cursor position and
     * movement
     *
     * @param shape The shape to scale
     * @param xstart Mouse X start position
     * @param xend Mouse X end position
     * @param ystart Mouse Y start position
     * @param yend Mouse Y end position
     */
    public void Rescale(baseShape shape, int xstart, int xend, int ystart, int yend) {
        //get the coordinates of the center of the shape
        int centerx = shape.x + (shape.width / 2);
        int centery = shape.x + (shape.height / 2);

        int xdiff = xend - xstart;
        int ydiff = yend - ystart;

        //invert scaling if the movement happened higher and to the left of the shape
        if (xend < centerx) {
            int test = xdiff / 2;
            shape.width -= xdiff;
            shape.x += test;
        } else {
            int test = xdiff / 2;
            shape.width += xdiff;
            shape.x -= test;
        }

        if (yend < centery) {
            int testy = ydiff / 2;
            shape.height -= ydiff;
            shape.y += testy;
        } else {
            int testy = ydiff / 2;
            shape.height += ydiff;
            shape.y -= testy;
        }
    }
}
