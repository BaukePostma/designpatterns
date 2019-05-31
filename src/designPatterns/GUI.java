package designPatterns;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

/**
 *  Essentially the new main class. 
 * @author Bauke
 */
public class GUI {
    
   
   Invoker invoker = new Invoker();
   

    
    Canvas mainCanvas =  Canvas.getInstance();
    JFrame frame = new JFrame("PaintPlus");
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Rectangle");
    JMenu m2 = new JMenu("Circle");
    JMenu m3 = new JMenu("Select");
    JMenu m4 = new JMenu("Group");
    JMenu m5 = new JMenu("Drag");
    JMenu m6 = new JMenu("Scale");
    JMenu m7 = new JMenu("File");
    JMenu m8 = new JMenu("History");
    JMenuItem action1 = new JMenuItem("Create");
    JMenuItem action2 = new JMenuItem("Create");
    JMenuItem action3 = new JMenuItem("Select");
    JMenuItem action4 = new JMenuItem("Group");
    JMenuItem action5 = new JMenuItem("Drag");
    JMenuItem action6 = new JMenuItem("Scale");
    JMenuItem action7 = new JMenuItem("Save");
    JMenuItem action8 = new JMenuItem("Load");
    JMenuItem action9 = new JMenuItem("Undo");
    JMenuItem action10 = new JMenuItem("Redo");

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
        mb.add(m7);
        mb.add(m8);
        m1.add(action1);
        m2.add(action2);
        m3.add(action3);
        m4.add(action4);
        m5.add(action5);
        m6.add(action6);
        m7.add(action7);
        m7.add(action8);
        m8.add(action9);
        m8.add(action10);
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
              //  mainCanvas.setState("group");
              
              //Testshape
                 // baseShape q = drawShape("rectangle", 50, 50, 50, 50);
                  //ArrayList<IComposite> AddTo= new ArrayList<IComposite>(); 
                  //AddTo.add(q);
                  
                    //  CommandRectangle commandR = new CommandRectangle(mainCanvas.shapeList,q);
                      //invoker.AddAction(commandR);
                      
               ArrayList<IComposite> AddTo = mainCanvas.shapeList.getSelected();
              CommandGroup command = new CommandGroup(mainCanvas.shapeList,AddTo);
              invoker.AddAction(command);
              mainCanvas.repaint();
               
                
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
        action7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action7 performed");
                Saver q = new Saver();
                try {
                    q.Save(mainCanvas.shapeList, "Testsave.txt");
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                mainCanvas.setState("drag");
                //    System.out.println(mainCanvas.getState());
            }

        });
        action8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Action8 performed");
                Saver q = new Saver();
                try {
                    // mainCanvas.shapeList = null;
                    mainCanvas.shapeList = q.Load("Testsave.txt");
                    mainCanvas.repaint();
                    //Load
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        action9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Undo Clicked+\n");
                invoker.UndoAction();
            }
        });
        action10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Redo Clicked\n");
                // Check if there is anything left to redo
              invoker.DoAction();
 

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
// What actions to take for different events

            @Override
            public void mousePressed(MouseEvent e) {
                mouseDown = true;
                // Get mouse X and Y
                xpos = e.getX();
                ypos = e.getY();

                if (mainCanvas.getState() == "select") {
                    //Loop over every element in the shapelist
//                    for (int i = 0; i < mainCanvas.shapeList.size(); i++) {
//                        if (pointCheck(xpos, ypos, mainCanvas.shapeList.get(i))) {
//                            //  mainCanvas.shapeList.get(i).isSelected = true;
//                            mainCanvas.shapeList.get(i).toggleSelection();
//                            System.out.println("Shape" + i + " is set to " + mainCanvas.shapeList.get(i).isSelected);
//                        }
//                    }
                    
                    //NEW
                   SelectVisitor visitor = new SelectVisitor(xpos,ypos);
                  mainCanvas.shapeList.Accept(visitor);
                    
                } else if (mainCanvas.getState() == "drag") {
                    System.out.print("Drag state = true");
                }
                mainCanvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDown = false;
                xend = e.getX();
                yend = e.getY();
                if (mainCanvas.getState() == "rectangle") {
                    //ClearHistory(undocount);
                    baseShape q = drawShape("rectangle", xpos, ypos, xend, yend);
                    invoker.AddAction(new CommandRectangle(mainCanvas.shapeList, q));
                   
                   // CommandHistory.add(command);
                    //command.Execute();
                    
                } else if (mainCanvas.getState() == "circle") {
                     //Cl//earHistory(undocount);
                    baseShape q = drawShape("circle",xpos,ypos,xend,yend);
                    invoker.AddAction(new CommandElipse(mainCanvas.shapeList,q));
                    //CommandElipse command  = );
                   // CommandHistory.add(command);
                   // command.Execute();
                   //drawShape("circle", xpos, ypos, xend, yend);

                } else if (mainCanvas.getState() == "drag") {
               //      ClearHistory(undocount);
                    int xdiff = xend - xpos;
                    int ydiff = yend - ypos;
                    //startDrag(xdiff, ydiff);
                   
                    invoker.AddAction(new CommandDrag(mainCanvas.shapeList,xdiff,ydiff));
                   // CommandDrag command = new CommandDrag(getSelected(),xdiff,ydiff);
                    //CommandHistory.add(command);
               //     command.Execute();
;

                } else if (mainCanvas.getState() == "scale") {
                    int xdiff = xend - xpos;
                    int ydiff = yend - ypos;
                    //scaleShape(xpos, xend, ypos, yend);
                    invoker.AddAction(new CommandScale(mainCanvas.shapeList,xpos,xend,ypos,yend));
                   // CommandScale command = new CommandScale(getSelected(),xpos,xend,ypos,yend);
                  //  CommandHistory.add(command);
                    //command.Execute();
                }
                //Forces the canvas to update
                mainCanvas.repaint();
            }
        });

        mainCanvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mainCanvas.repaint();
                //System.out.print("Mouse moved");
            }
        });
    }


    /**
     * Draws rectangles or circles depending on the given parameters
*
     */
    baseShape drawShape(String type, int xpos, int ypos, int xend, int yend) {
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
            return shape;
            //mainCanvas.shapeList.add(shape);

        } else {
            Rectangle shape = new Rectangle(lowestX, lowestY, width, height);
            return shape;
            //mainCanvas.shapeList.add(shape);
        }
    }

    //Gets called from a mouse-drag. Calls the scale function of individual componenets
//    public void scaleShape(int xstart, int xend, int ystart, int yend) {
//
//        ArrayList<baseShape> scaled = getSelected();
//        for (baseShape shape : scaled) {
//            shape.Rescale(xstart, xend, ystart, yend);
//        }
//    }

    // Moves selected shapes by the mouse offset
//    void startDrag(int x, int y) {
//        // Keep track of all the selected 
//        ArrayList<baseShape> dragged = getSelected();
//        for (baseShape shape : dragged) {
//            System.out.println("Old " + shape.x);
//            shape.x += x;
//            shape.y += y;
//            System.out.println("New  " + shape.x);
//        }
//        mainCanvas.repaint();
//    }

    // Gets all the selected shapes
//    ArrayList<baseShape> getSelected() {
//        ArrayList<baseShape> movelist = new ArrayList();
////        for (int i = 0; i < mainCanvas.shapeList.size(); i++) {
////            if (mainCanvas.shapeList.get(i).isSelected) {
////                movelist.add(mainCanvas.shapeList.get(i));
////
////            }
////        }
//        GetSelectedVisitor visitor = new GetSelectedVisitor();
//        mainCanvas.shapeList.Accept(visitor);
//        return movelist;
//    }

}