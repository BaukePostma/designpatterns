/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package designPatterns;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.*;

/**
 *
 * @author Bauke
 */
import java.util.Scanner;

public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   // Create a frame
testGUI MainUI = new testGUI();
MainUI.setVisible(true);
//q.run();
     
// Add a component with a custom paint method
 
//JPanel p = new JPanel(); 
//Frame frame = new Frame();
CustomPaintComponent c = new CustomPaintComponent();
//MainUI.add(p);

Canvas can = new Canvas();

MainUI.add(can);

// Display the frame
 
int frameWidth = 300;
int frameHeight = 300;
 
//frame.setSize(frameWidth, frameHeight);
 
//frame.setVisible(true);
        
        
    }
    
    
}
