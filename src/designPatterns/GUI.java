/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Bauke
 */
public class GUI {

    Canvas mainCanvas = new Canvas();
    JFrame frame = new JFrame("PaintPlus");
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Rectangle");
    JMenu m2 = new JMenu("Circle");
    JMenu m3 = new JMenu("Select");
    JMenu m4 = new JMenu("Group");
    JMenu m5 = new JMenu("Drag");
    JMenuItem action1 = new JMenuItem("Create");
    JMenuItem action2 = new JMenuItem("Create");
    JMenuItem action3 = new JMenuItem("Select");
    JMenuItem action4 = new JMenuItem("Group");
    JMenuItem action5 = new JMenuItem("Drag");

    boolean isDragging = false;
    public GUI(int height, int width) {
        // Create the canvas

        // Create the main frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(height, width);
        //Create the top menu

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);

        m1.add(action1);
        m2.add(action2);
        m3.add(action3);
        m4.add(action4);
        m5.add(action5);
        //    Actionlistener q = new Actionlistener(){
        //  }
        //  m1.add(action);
        //  m1.add(action);
        // Create the listeners or the menu
        //m1.addMenuListener(new SampleMenuListener());
        action1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action1 performed");
                mainCanvas.setState("rectangle");
            }
        });
        action2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action2 performed");
                mainCanvas.setState("circle");
            }
        });
        action3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action3 performed");
                mainCanvas.setState("select");
            }
        });
        action4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action4 performed");
                mainCanvas.setState("group");
            }
            
        });
            action5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action5 performed");
                mainCanvas.setState("drag");
            //    System.out.println(mainCanvas.getState());
            }
            
        });
        mainCanvas.addMouseListener(new MouseAdapter() {

            boolean mouseDown = true;
            int xpos = 0;
            int ypos = 0;
            int xend = 0;
            int yend = 0;

            @Override
            public void mousePressed(MouseEvent e) {
                mouseDown = true;
                xpos = e.getX();
                ypos = e.getY();

                if (mainCanvas.getState() == "rectangle") {
//Create a new rectangle

                } else if (mainCanvas.getState() == "circle") {

                } else if (mainCanvas.getState() == "select") {

                    //Loop over every element in the shapelist
                    for (int i = 0; i < mainCanvas.shapeList.size(); i++) {
                        if (pointCheck(xpos, ypos, mainCanvas.shapeList.get(i))) {
                            mainCanvas.shapeList.get(i).isSelected = true;
                            System.out.println("Shape" +i+" is set to " +   mainCanvas.shapeList.get(i).isSelected);
                        }
                    }
                } else if (mainCanvas.getState() == "drag") {
                    System.out.print("Drag state = true");
                    startDrag(xpos,ypos);
                    //
                    // Get selected shapes, put them in a list
                    ///  ArrayList<baseShape> shapeList = new ArrayList();

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDown = false;
                xend = e.getX();
                yend = e.getY();

                if (mainCanvas.getState() == "rectangle") {
                    //Create a new rectangle
                    //    xpos = e.getX();
                    //  ypos = e.getY();
                    int width = xend - xpos;
                    int height = yend - ypos;
                    // Draai width & height om zodat ze altijd positief zijn
                    if (width < 0) {
                        width = width * -1;
                    }
                    if (height < 0) {
                        height = height * -1;
                    }
                    int lowestX;
                    if (xpos < xend) {
                        lowestX = xpos;
                    } else {
                        lowestX = xend;
                    }
                    int lowestY;
                    if (ypos < yend) {
                        lowestY = ypos;
                    } else {
                        lowestY = yend;
                    }
                    Rectangle newRect = new Rectangle(lowestX, lowestY, width, height);
                    mainCanvas.shapeList.add(newRect);
                    mainCanvas.repaint();
                } else if (mainCanvas.getState() == "circle") {

                } else if (mainCanvas.getState() == "select") {

                } else if (mainCanvas.getState() == "drag"){
                    stopDrag();
                }

            }
        });
        // Code to add sub-elements to JMenu items. Leaving this here for reference
        //  JMenuItem m11 = new JMenuItem("Open");
        //    m1.add(m11);
        // Add it to the top of our JFrame using a north Borderlayout
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, mainCanvas);
        frame.setVisible(true);
    }
// Check if a given mouse coordinate falls within the boundaries of a shape
    boolean pointCheck(int mouseX, int mouseY, baseShape testshape) {

        if (mouseX > testshape.x && mouseX < testshape.x + testshape.width
                && mouseY > testshape.y && mouseY < testshape.y + testshape.height) {
            System.out.println("Selected a shape");
            return true;

        }

        return false;
    }

    void startDrag(int x,int y) {
        // Keep track of all the selected 
        isDragging = true;
        ArrayList<baseShape> dragged = getSelected();
        for(baseShape shape :dragged){
            System.out.println("Old "+ shape.x);
            shape.x =x;
            shape.y = y;
              System.out.println("New  "+ shape.x);
        }
        mainCanvas.repaint();
    }

    void stopDrag() {
        isDragging = false;
    }
    // Gets all the selected shapes
    ArrayList<baseShape> getSelected(){
            ArrayList<baseShape> movelist = new ArrayList();
        for (int i = 0; i < mainCanvas.shapeList.size(); i++) {
            if (mainCanvas.shapeList.get(i).isSelected) {
                movelist.add(mainCanvas.shapeList.get(i));

            }
        }
        return movelist;
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
