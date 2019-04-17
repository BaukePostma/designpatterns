/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Bauke
 */
public abstract class baseShape {
    // TODO add getters setters
    int x= 50;
    int y = 50;
    int width =50;
    int height = 50;

        public abstract void Draw(Graphics g) ;
         
                }

