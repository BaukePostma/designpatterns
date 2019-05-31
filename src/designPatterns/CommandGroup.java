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
public class CommandGroup implements ICommand {

    Group shapelist;
    ArrayList<IComposite> freshShapes;
    Group newGroup;

    public CommandGroup(Group shapelist, ArrayList<IComposite> freshShapes) {
        this.shapelist = shapelist;
        this.freshShapes = freshShapes;
    }

    @Override
    public void Execute() {
        newGroup = new Group();
        newGroup.isSelected = true;

        /**
         * Todo: Test this extensively
         *
         * For every composite in freshShapes (Selected composites) - Remove the
         * composite from the shapelist - Add thecomposite to a new group - Add
         * the new group to the shapelist
         */
        for (IComposite shape : freshShapes) {
            shapelist.RemoveShape(shape);
            newGroup.AddShape(shape);
            System.out.println("Removed a shape, added a shape");
        }
        shapelist.AddShape(newGroup);
        System.out.println("Added new group to Shapelist   ");

    }

    @Override
    public void Undo() {
        // Get the elements out of the group
        // Remove the group from the table
        // Add the shapes TODO: ( at the same level as the old group instead of adding them to the first level)

        for (IComposite shape : newGroup.childshapes) {
            shapelist.AddShape(shape);
        }
        shapelist.RemoveShape(newGroup);
    }

}
