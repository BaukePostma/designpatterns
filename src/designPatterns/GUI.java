/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author Bauke
 */
public class GUI {
    public GUI(int height,int width){
      // Create the main frame
           JFrame frame = new JFrame("PaintPlus");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(height,width);
           //Create the top menu
          JMenuBar  mb = new JMenuBar();
          JMenu m1 = new JMenu("Circle");
          JMenu m2 = new JMenu("Rectangle");
          JMenu m3 = new JMenu("Select");
          JMenu m4 = new JMenu("Group");
          JMenuItem action = new JMenuItem("ACTION");
          mb.add(m1);
          mb.add(m2);
          mb.add(m3);
          mb.add(m4);
        //  m1.add(action);
          // Create the listeners or the menu
          m1.addMenuListener(new SampleMenuListener());
          
          action.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action performed");
            }
        });
          // Create the canvas
          Canvas mainCanvas = new Canvas();
          
          // Code to add sub-elements to JMenu items. Leaving this here for reference
          //  JMenuItem m11 = new JMenuItem("Open");
          //    m1.add(m11);
          // Add it to the top of our JFrame using a north Borderlayout
          frame.getContentPane().add(BorderLayout.NORTH,mb);
          frame.getContentPane().add(BorderLayout.CENTER,mainCanvas);
          frame.setVisible(true);
    }
     
}
// TEST TES TEST 
class SampleMenuListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("menuSelected");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        System.out.println("menuDeselected");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        System.out.println("menuCanceled");
    }
}