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
 * @author Bauke & Demi
 */
public class Saver {

    /**
     * Creates a new save visitor to go over the Composite and passes the
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
     * Reads a text file, returns the shapelist (The main group where all the
     * shapes and groups are stored)
     */
    Group Load(String fileName) throws FileNotFoundException, IOException {

        Group shapelist = new Group();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Group newgroup = null;
            int groupcount = 0;
            while ((line = reader.readLine()) != null) {
                String[] words;
                words = line.split(" ");
            }
        }
        return shapelist;
    }
}
