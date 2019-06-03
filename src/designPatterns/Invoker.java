/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.util.ArrayList;

/**
 * Invoker class keeps track of the history and executes commands sent to it.
 *
 * @author Bauke & Demi
 */
public class Invoker {

    //creating list of executed commands, vars
    ArrayList<ICommand> CommandHistory = new ArrayList<>();
    int undocount = 0;

    //function to clear made commands, add command to the history command list and execute it
    public void AddAction(ICommand c) {
        ClearHistory();
        CommandHistory.add(c);
        c.Execute();
    }

    //function to perform redo task
    public void DoAction() {

        //if there are things to be undone
        if (undocount > 0) {
            //perform function to redo command and size down the undocount
            CommandHistory.get(CommandHistory.size() - undocount).Execute();
            undocount--;
        } 
        //if there is nothing left to redo
        else {
            //print that there is nothing left to redo...
            System.out.print("Nothing left to redo");
        }
    }

    //function to perform undo task
    public void UndoAction() {
        int test = CommandHistory.size() - undocount - 1;
        //if there are any commands that can be undone
        if (CommandHistory.size() - undocount > 0) {
            System.out.print("Command nr. " + test + "\n");
            
            //only undo if there's something to undo
            CommandHistory.get(CommandHistory.size() - undocount - 1).Undo();
            undocount++;
        } 
        //if there is nothing left to undo
        else {
            //print that there is nothing left to undo...
            System.out.println("Undo failed, nothing left to undo\n");
        }
    }

    //function to clear made commands
    private void ClearHistory() {
        //check if we can actually clear that amount of commands
        if (undocount > 0) {
            for (int i = 0; i < undocount; i++) {
                this.CommandHistory.remove(CommandHistory.size() - 1);
            }
            undocount = 0;
        }
    }
}
