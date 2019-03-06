/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

/**
 *
 * @author Bauke
 */
import java.util.Scanner;

public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = Integer.parseInt(reader.nextLine());
        double circumference = 2*Math.PI *num;
        System.out.println(circumference);
        
    }
    
}
