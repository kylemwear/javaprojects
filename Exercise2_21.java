/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 1
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment1;

import java.util.Scanner;

public class Exercise2_21 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // next 3 sets of statements gather investment amount, 
        // annual interest, and number of years from user
        System.out.print("Enter investment amount: ");
        double amount = input.nextDouble();
        
        System.out.print("Enter annual interest rate in percentage: ");
        double interest = input.nextDouble();
        
        System.out.print("Enter number of years: ");
        int years = input.nextInt();
        
        /* follows the future value formula
         * the first part of the pow method divides the annual interest by 12 
         * (for monthly rate) and then 100 to get a usable decimal
         * then it adds 1 to that. the second part puts the first part to the 
         * power of years * 12 (to get total amount of months). 
         * finally the investment amount is multiplied with the entire 
         * pow result to get future value
         */     
        double fv = amount * Math.pow(1 + interest / 12 / 100, (years * 12));

        System.out.printf("Future value is: $" +  "%.2f", fv);
    }
    
}
