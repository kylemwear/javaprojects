/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 1
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment1;

import java.util.Scanner;

public class Exercise2_5 {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        // Get subtotal and gratuity rates from user
        System.out.print("Please enter the subtotal and a gratuity rate: ");
        int subtotal = input.nextInt();
        double rate = input.nextDouble();
        
        // convert rate to a decimal to find gratuity on subtotal
        double gratuity = subtotal * (rate /100);
        
        // adds gratuity to subtotal to get total
        double total = gratuity + subtotal;

        System.out.println("The gratuity is $" + gratuity 
                + " and total is $" + total);
        
        
    }
    
}
