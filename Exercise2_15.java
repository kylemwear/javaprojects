/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 1
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment1;

import java.util.Scanner;

public class Exercise2_15 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // get first two coords from user
        System.out.print("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        
        // get second two coords from user
        System.out.print("Enter x2 and y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        
        /* subtracts x1 from x2 and squares it
         * does the same to y1 and y2 then adds both results together
         * and finally puts that result to the .5 power to square
         * root the result
         */
        double distance = Math.pow((Math.pow(x2 - x1, 2) 
                + Math.pow(y2 - y1, 2)), 0.5);
        
        System.out.println("The distance between the points is: " + distance);
    }
    
}
