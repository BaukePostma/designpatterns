/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.util.ArrayList;

/**
 * Invoker class keeps track of the history and exectues commands sent to it.
 * @author Bauke
 */
public class Invoker {

    ArrayList<ICommand> CommandHistory = new ArrayList<ICommand>();
    int undocount = 0;

    public void AddAction(ICommand c) {
        ClearHistory();
        CommandHistory.add(c);
        c.Execute();
    }

    public void DoAction() {

        if (undocount > 0) {
            CommandHistory.get(CommandHistory.size() - undocount).Execute();
            undocount--;
        } else {
            System.out.print("Nothing left to redo");
        }
    }

    public void UndoAction() {

        int test = CommandHistory.size() - undocount - 1;
        if (CommandHistory.size() - undocount > 0) {
            System.out.print("Command nr. " + test);
            // Only undo if there's something to undo
            CommandHistory.get(CommandHistory.size() - undocount - 1).Undo();
            undocount++;
        } else {
            System.out.println("Undo failed, nothing left to undo");
        }

    }

    private void ClearHistory() {
        //Check if we can actually clear that amount of commands
        if (undocount > 0) {
            for (int i = 0; i < undocount; i++) {
                this.CommandHistory.remove(CommandHistory.size() - 1);
            }
            undocount = 0;
        }

    }

}
