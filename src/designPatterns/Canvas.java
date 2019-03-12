/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;
        
/**
 *
 * @author Bauke
 */
public class Canvas extends JPanel{
    
    // Test main, remove this
  public static void main(String[] args) {}{
    
}

    public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    g.drawString("a",10,20);
    }
    
}


