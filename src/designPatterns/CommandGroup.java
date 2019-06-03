/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.util.ArrayList;

/**
 * Command pattern for grouping objects
 * @author Bauke & Demi
 */
public class CommandGroup implements ICommand {
    //creating listst for grouping
    Group shapelist;
    ArrayList<IComposite> freshShapes;
    Group newGroup;

    //constructor, initializing vars
    public CommandGroup(Group shapelist, ArrayList<IComposite> freshShapes) {
        this.shapelist = shapelist;
        this.freshShapes = freshShapes;
    }

    //execute function to add group to canvas
    @Override
    public void Execute() {
        newGroup = new Group();
        newGroup.isSelected = true;

        /**
         * For every composite in freshShapes (Selected composites) - Remove the
         * composite from the shapelist - Add the composite to a new group - Add
         * the new group to the shapelist
         */
        for (IComposite shape : freshShapes) {
            shapelist.RemoveShape(shape);
            newGroup.AddShape(shape);
            System.out.println("Removed a shape, added a shape\n");
        }
        shapelist.AddShape(newGroup);
        System.out.println("Added new group to Shapelist\n");

    }

    @Override
    public void Undo() {
        // Get the elements out of the group
        // Remove the group from the table
        for (IComposite shape : newGroup.childshapes) {
            shapelist.AddShape(shape);
        }
        shapelist.RemoveShape(newGroup);
    }

}
