/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 *
 * @author Bauke
 */
public class SelectVisitor implements Visitor{
    int MouseX;
    int MouseY;
    
   
    public SelectVisitor(int xpos ,int ypos){
        this.MouseX = xpos;
        this.MouseY = ypos;
    }
    @Override
    public void visit(Group group) {
         System.out.print("Visiting group");
        group.isSelected = false;
        for (IComposite shape:group.childshapes){
            shape.Accept(this);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(baseShape shape) {
      // Logic to check if the visiting shape should be selected
    System.out.print("Visiting baseShape");
      if (pointCheck(MouseX, MouseY, shape)){
          shape.isSelected = ! shape.isSelected;
      }
    }
    
        /**
     * Check if a given mouse coordinate falls within the boundaries of a shape.
     * Used for selecting
     */
    boolean pointCheck(int mouseX, int mouseY, baseShape testshape) {

        if (mouseX > testshape.x && mouseX < testshape.x + testshape.width
                && mouseY > testshape.y && mouseY < testshape.y + testshape.height) {
            System.out.println("Selected a shape");
            return true;
        }
        return false;
    }

    
}
