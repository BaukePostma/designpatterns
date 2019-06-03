/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 * Basic interface for the command pattern. Forces classes to implement the
 * execute and undo commands
 *
 * @author Bauke & Demi
 */
public interface ICommand {

    public void Execute();

    public void Undo();
}
