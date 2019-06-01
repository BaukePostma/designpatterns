package designPatterns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Contains the save and load functions
 *
 * @author Bauke
 */
public class Saver {

    /**
     * Creates a new savevisitor to go over the Composite and passes the
     * printwriter to the visitor
     *
     * @param shapelist
     */
    void Save(Group shapelist, String fileName) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        SaveVisitor visitor = new SaveVisitor(printWriter);
        shapelist.Accept(visitor);

        printWriter.close();
    }

    /**
     * Reads a textfile, returns the shapelist (The main group where all the
     * shapes and groups are stored)
     */
    Group Load(String fileName) throws FileNotFoundException, IOException {

        Group shapelist = new Group();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        Group newgroup = null; 
        int groupcount = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            switch (words[0]) {

                case "rectangle":
                    Rectangle rect = new Rectangle(
                            Integer.parseInt(words[1]),
                            Integer.parseInt(words[2]),
                            Integer.parseInt(words[3]),
                            Integer.parseInt(words[4])
                    );
                    if (groupcount > 0) {
                        newgroup.AddShape(rect);
                    } else {
                        shapelist.AddShape(rect);
                    }

                    break;
                    
                case "elipse:":
                    Elipse el = new Elipse(
                            Integer.parseInt(words[1]),
                            Integer.parseInt(words[2]),
                            Integer.parseInt(words[3]),
                            Integer.parseInt(words[4])
                    );
                    if (groupcount > 0) {
                        newgroup.AddShape(el);
                    } else {
                        shapelist.AddShape(el);
                    }

                    break;
                    
                default:
                    if(newgroup == null){
                        // If true, this is the first group at the top of the tree 
                        newgroup = new Group();
                    }else{
                             shapelist.AddShape(newgroup);
                    }
               
                    groupcount = Integer.parseInt(words[1]);
                    newgroup = new Group();
                    System.out.print("It's a group");

            }
        }
        reader.close();

        return shapelist;
    }
}
