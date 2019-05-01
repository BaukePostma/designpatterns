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
        JMenu m6 = new JMenu("Scale");
    JMenuItem action1 = new JMenuItem("Create");
    JMenuItem action2 = new JMenuItem("Create");
    JMenuItem action3 = new JMenuItem("Select");
    JMenuItem action4 = new JMenuItem("Group");
    JMenuItem action5 = new JMenuItem("Drag");
    JMenuItem action6 = new JMenuItem("Scale");
    public GUI(int height, int width) {
        // Create the main frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(height, width);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, mainCanvas);
        frame.setVisible(true);
        //Create the top menu
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);
        mb.add(m6);
        m1.add(action1);
        m2.add(action2);
        m3.add(action3);
        m4.add(action4);
        m5.add(action5);
 m6.add(action6);

        //Add handlers to the buttons to process events
        action1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Create Rectangle Button Clicked\n");
                mainCanvas.setState("rectangle");
            }
        });
        action2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Create Circle Button Clicked\n");
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
        action6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action6 performed");
                mainCanvas.setState("scale");
                //    System.out.println(mainCanvas.getState());
            }

        });

        // Add a mouselistener to the canvas to listen to click events
        mainCanvas.addMouseListener(new MouseAdapter() {
            boolean mouseDown = true;
            // Store Mousepress values
            int xpos = 0;
            int ypos = 0;
            //Store mouserelease values
            int xend = 0;
            int yend = 0;

            @Override
            public void mousePressed(MouseEvent e) {
                mouseDown = true;
                // Get mouse X and Y
                xpos = e.getX();
                ypos = e.getY();

                if (mainCanvas.getState() == "select") {
                    //Loop over every element in the shapelist
                    for (int i = 0; i < mainCanvas.shapeList.size(); i++) {
                        if (pointCheck(xpos, ypos, mainCanvas.shapeList.get(i))) {
                          //  mainCanvas.shapeList.get(i).isSelected = true;
                            mainCanvas.shapeList.get(i).toggleSelection();
                            System.out.println("Shape" + i + " is set to " + mainCanvas.shapeList.get(i).isSelected);
                        }
                    }
                } else if (mainCanvas.getState() == "drag") {
                    System.out.print("Drag state = true");

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDown = false;
                xend = e.getX();
                yend = e.getY();

                if (mainCanvas.getState() == "rectangle") {
                    drawShape("rectangle", xpos, ypos, xend, yend);

                } else if (mainCanvas.getState() == "circle") {
                    drawShape("circle", xpos, ypos, xend, yend);
                } else if (mainCanvas.getState() == "drag") {
                    int xdiff = xend - xpos;
                    int ydiff = yend - ypos;
                    startDrag(xdiff, ydiff);
                }else if(mainCanvas.getState() == "scale"){
                                        int xdiff = xend - xpos;
                    int ydiff = yend - ypos;
                    scaleShape(xdiff,ydiff);
                }
                mainCanvas.repaint();
            }
         
        });
        
          mainCanvas.addMouseMotionListener(new MouseAdapter() {
           @Override
              public void mouseMoved(MouseEvent e) {
                  mainCanvas.repaint();
            System.out.print("Mouse moved");
    }
    });
    }
// Check if a given mouse coordinate falls within the boundaries of a shape. Used for selecting 
    boolean pointCheck(int mouseX, int mouseY, baseShape testshape) {

        if (mouseX > testshape.x && mouseX < testshape.x + testshape.width
                && mouseY > testshape.y && mouseY < testshape.y + testshape.height) {
            System.out.println("Selected a shape");
            return true;

        }

        return false;
    }
// Draws rectangles or circles depending on the given parameters
    void drawShape(String type, int xpos, int ypos, int xend, int yend) {
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
        if (type == "circle") {
            Elipse shape = new Elipse(lowestX, lowestY, width, height);
            mainCanvas.shapeList.add(shape);

        } else if (type == "rectangle") {
            Rectangle shape = new Rectangle(lowestX, lowestY, width, height);
            mainCanvas.shapeList.add(shape);
        }
        mainCanvas.repaint();
    }
    public void scaleShape(int xdif,int ydif){
           ArrayList<baseShape> scaled = getSelected();
           for(baseShape shape:scaled){
               shape.Rescale(true);
           }
    }
    // Moves selected shapes by the mouse offset
    void startDrag(int x, int y) {
        // Keep track of all the selected 
        ArrayList<baseShape> dragged = getSelected();
        for (baseShape shape : dragged) {
            System.out.println("Old " + shape.x);
            shape.x += x;
            shape.y += y;
            System.out.println("New  " + shape.x);
        }
        mainCanvas.repaint();
    }

    // Might be usefull later? kinda forgot
    void stopDrag() {

    }

    // Gets all the selected shapes
    ArrayList<baseShape> getSelected() {
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
