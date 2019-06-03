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
 * Essentially the new main class.
 *
 * @author Bauke & Demi
 */
public class GUI {
    //creating invoker object
    Invoker invoker = new Invoker();

    //creating the canvas and the menu objects
    Canvas mainCanvas = Canvas.getInstance();
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

    //constructor, initializing vars, adding menu items to menubar, designing frame
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
        
        //ddd handlers to the buttons to process events
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
                System.out.print("Select Button Clicked\n");
                mainCanvas.setState("select");
            }
        });
        action4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Group Button Clicked\n");
                
                //add selected shapes to the shapeList, repaint canvas
                ArrayList<IComposite> AddTo = mainCanvas.shapeList.getSelected();
                CommandGroup command = new CommandGroup(mainCanvas.shapeList, AddTo);
                invoker.AddAction(command);
                mainCanvas.repaint();
            }
        });
        
        action5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Drag Button Clicked\n");
                mainCanvas.setState("drag");
            }
        });
        
        action6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Scale Button Clicked\n");
                mainCanvas.setState("scale");
            }
        });
        
        action7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Save Button Clicked\n");
                Saver q = new Saver();
                //when clicked, save the current state of the canvas to a text file
                try {
                    q.Save(mainCanvas.shapeList, "Testsave.txt");
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                //artistic choice, doesn't mean anything
                mainCanvas.setState("drag");
            }
        });
        
        action8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Load Button Clicked\n");
                Saver q = new Saver();
                try {
                    mainCanvas.shapeList = q.Load("Testsave.txt");
                    mainCanvas.revalidate();
                    mainCanvas.repaint();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        action9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //when clicked, call undo function from invoker object
                System.out.print("Undo Clicked\n");
                invoker.UndoAction();
            }
        });
        
        action10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Redo Clicked\n");
                //check if there is anything left to redo
                //when clicked, call redo function from invoker object
                invoker.DoAction();
            }
        });

        //ddd a mouselistener to the canvas to listen to click events
        mainCanvas.addMouseListener(new MouseAdapter() {
            boolean mouseDown = true;
            //store mousepress values
            int xpos = 0;
            int ypos = 0;
            
            //store mouserelease values
            int xend = 0;
            int yend = 0;
            
            //what actions to take for different events
            @Override
            public void mousePressed(MouseEvent e) {
                mouseDown = true;
                //get mouse X and Y
                xpos = e.getX();
                ypos = e.getY();

                //is select is clicked, call select visitor
                if ("select".equals(mainCanvas.getState())) {
                    SelectVisitor visitor = new SelectVisitor(xpos, ypos);
                    mainCanvas.shapeList.Accept(visitor);
                } 
                //is drag clicked, call drag visitor
                else if ("drag".equals(mainCanvas.getState())) {
                    System.out.print("Drag state = true");
                }
                //repaint canvas after action is performed
                mainCanvas.repaint();
            }

            //when mouse is released, stuff should happen
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDown = false;
                xend = e.getX();
                yend = e.getY();
                
                //if mouse was released on a rectangle, check x/y vals
                if (null != mainCanvas.getState()) switch (mainCanvas.getState()) {
                    case "rectangle":
                        invoker.AddAction(new CommandRectangle(mainCanvas.shapeList, xpos, ypos, xend, yend));
                        break;
                    
                    //if mouse was released on a ellipse, check x/y vals
                    case "circle":
                        invoker.AddAction(new CommandElipse(mainCanvas.shapeList, xpos, ypos, xend, yend));
                        break;
                        
                    //if mouse was released after dragging, check invoker action and change pos of shape
                    case "drag":{
                        int xdiff = xend - xpos;
                        int ydiff = yend - ypos;
                        
                        invoker.AddAction(new CommandDrag(mainCanvas.shapeList, xdiff, ydiff));
                        break;
                        }
                    
                    //if mouse was released after scaling, check invoker action and change size of shape
                    case "scale":{
                        int xdiff = xend - xpos;
                        int ydiff = yend - ypos;
                        invoker.AddAction(new CommandScale(mainCanvas.shapeList, xpos, xend, ypos, yend));
                            break;
                        }
                    default:
                        break;
                }
                //forces the canvas to update
                mainCanvas.repaint();
            }
        });

        //repaint the canvas when the mouse moved
        mainCanvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mainCanvas.repaint();
            }
        });
    }
}
