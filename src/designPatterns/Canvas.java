/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
        
/**
 *
 * @author Bauke
 */
public class Canvas extends JPanel{
        ArrayList<baseShape> shapeList = new ArrayList();
    enum state{
        RECTANGLE,
        CIRCLE,
        MOVE,
        GROUP
    }  
    public Canvas(){
      //  state state = state.CIRCLE;
       Rectangle firstRect = new Rectangle();
       shapeList.add(firstRect);
    }

    
    


 
    public void paintComponent(Graphics g){
    super.paintComponent(g);
      
        for (int i = 0; i < shapeList.size(); i++) {
         // Draw all the elements in shapeVector
         shapeList.get(i).Draw(g);
        }
   g.drawString("a",10,20);
    }
}


