/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 1
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment1;

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // gets numbers to operate with from user
        System.out.print("Enter two numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        
        // gets operations user wants to do
        System.out.print("Enter operation (1 to Add, 2 to Subtract, "
                + "3 to Multiply, 4 to Divide): ");
        int operation = input.nextInt();
        
        // if/else if block to determine which operation to do and then 
        // modifies result variable with answer
        double result = 0;
        if (operation == 1) {
            result = num1 + num2;
        } else if (operation == 2) {
            result = num1 - num2;
        } else if (operation == 3) {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }
        
        System.out.print("Result: " + result);
    }
    
}
