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
public class Rectangle extends baseShape{
   
    public Rectangle(int x,int y, int width,int height){
        this.x =x;
        this.y =y;
        this.width=width;
        this.height =height;
        
    }
  

    @Override
    public void Draw(Graphics g) {
           //       super.paintComponent(g);
          // Retrieve the graphics context; this object is used to paint shapes
         Graphics2D g2d = (Graphics2D)g;
         g2d.drawRect(x, y, width, height);
    }
    public void paintComponent(Graphics g){

             System.out.print("IT DRAWS");
    }
}
