/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Bauke
 */
public class Saver {

    /**
     * Takes a shapelist, stores it as a file. This version only saves shapes
     *
     * @param shapelist
     */
    void Save(ArrayList<baseShape> shapelist, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (baseShape shape : shapelist) {
            printWriter.println(
                    shape.type + " "
                    + shape.x + " "
                    + shape.y + " "
                    + shape.width + " "
                    + shape.height + " "
            );
        }
        printWriter.close();
    }

    /**
     * Returns the data
     */
    ArrayList<baseShape> Load(String fileName) throws FileNotFoundException, IOException {
        ArrayList<baseShape> shapelist = new ArrayList<baseShape>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            switch (words[0]) {
                case "Rectangle":
                    Rectangle rect = new Rectangle(
                            Integer.parseInt(words[1]),
                            Integer.parseInt(words[2]),
                            Integer.parseInt(words[3]),
                            Integer.parseInt(words[4])
                    );
                    shapelist.add(rect);
                    break;
                case "Elipse:":
                    Elipse el = new Elipse(
                            Integer.parseInt(words[1]),
                            Integer.parseInt(words[2]),
                            Integer.parseInt(words[3]),
                            Integer.parseInt(words[4])
                    );
                    shapelist.add(el);
                    break;
                default:
                    System.out.print("crap");

            }
        }
        reader.close();

        return shapelist;
    }
}
