/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.io.PrintWriter;

/**
 *
 * @author Bauke
 */
public class SaveVisitor implements Visitor{
    PrintWriter pw;
    public SaveVisitor(PrintWriter pw){
        this.pw=pw;
    }

    @Override
    public void visit(Group group) {
     
        pw.println("Group " + getConcreteShapeCount(group));
        
          for (IComposite shape : group.childshapes) {
              pw.print("\t\t");
                 shape.Accept(this);
           
        }
    
    }

    @Override
    public void visit(baseShape shape) {

          pw.println(
                    shape.type + " "
                    + shape.x + " "
                    + shape.y + " "
                    + shape.width + " "
                    + shape.height + " "
            );
    
    }
    
    
    private int getConcreteShapeCount(Group comp){
        int compcount =0;
        
        for(IComposite item : comp.childshapes){
        if(item instanceof Rectangle || item instanceof Elipse){
            compcount++;
        }
        }
        
        return compcount;
    }
    
}
