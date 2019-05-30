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
public class UndoScaleVisitor implements Visitor {
        @Override
    public void visit(Group group) {

       for (IComposite shape:group.childshapes){
            shape.Accept(this);
        }

    }

    @Override
    public void visit(baseShape shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
