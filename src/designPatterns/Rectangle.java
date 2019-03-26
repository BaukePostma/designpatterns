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
public class Rectangle implements baseShape{

int x= 50;
int y = 50;
int width =50;
int height = 50;

    @Override
    public void Draw(Graphics g) {
           //       super.paintComponent(g);
          // Retrieve the graphics context; this object is used to paint shapes
         Graphics2D g2d = (Graphics2D)g;
  
         g2d.drawRect(x, y, width, height);
        System.out.print("IT LIVES");

    }
    public void paintComponent(Graphics g){

             System.out.print("IT DRAWS");
    }
}
