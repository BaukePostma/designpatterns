/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bauke
 */
public class Group  implements IComposite {
    ArrayList<IComposite> childshapes ;
    boolean isSelected;

    public Group(){
        this.childshapes = new ArrayList<>();
        this.isSelected = false;
    }
    
        @Override
    public void drawShapes(Graphics g) {
            for (IComposite shape: childshapes){
                shape.drawShapes(g);
            }
    }
    public void AddShape(IComposite newshape){
        this.childshapes.add(newshape);
    }
    public void RemoveShape(IComposite newshape){
        this.childshapes.remove(newshape);
    }

    public void Draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Accept(Visitor visitor) {
        
       visitor.visit(this);
    }

    @Override
    public boolean isSelected() {
        return this.isSelected;
    }
        @Override
    public ArrayList<IComposite> getSelected() {
           ArrayList<IComposite> groupselected = new ArrayList<IComposite>();
        for(IComposite shape : childshapes){
            if(shape.isSelected()){
                    groupselected.addAll(  shape.getSelected());
            }
        
        }

        //single.add(this);
        return groupselected;
    }
}
