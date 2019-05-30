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
public class CommandGroup implements ICommand{
    Group shapelist;
    ArrayList<IComposite> freshShapes;
    
    public CommandGroup(Group shapelist,ArrayList<IComposite> freshShapes){
        this.shapelist = shapelist;
        this.freshShapes = freshShapes;
    }

    @Override
    public void Execute() {
            Group newGroup = new Group();
            newGroup.isSelected = true;
        // Add the new group to the shapelist. Remove the old references from the shapelist
        
        //TES THIS
        for(IComposite shape :freshShapes){
               shapelist.RemoveShape(shape);
                 newGroup.AddShape(shape);
                 System.out.println("Removed a shape, added a shape");
        }
        shapelist.AddShape(newGroup);
 System.out.println("Added new group to Shapelist   ");
   
      
    }

    @Override
    public void Undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
