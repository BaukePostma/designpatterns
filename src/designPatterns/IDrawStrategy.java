/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;

/**
 * Strategy pattern, making draw usable for all shapes / groups
 *
 * @author Bauke & Demi
 */
public interface IDrawStrategy {

    void Draw(Graphics g, int x, int y, int width, int height);

    @Override
    public String toString();

}
