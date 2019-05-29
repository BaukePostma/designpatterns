/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.util.ArrayList;

/**
 *
 * @author Bauke
 */
public class GetSelectedVisitor implements Visitor{

    ArrayList<IComposite> selectedShapes;
    
    @Override
    public void visit(Group group) {
       for(IComposite shape:group.childshapes){
           
           if (shape.isSelected()){
               selectedShapes.add(shape);
           }
       }
    }

    @Override
    public void visit(baseShape shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
