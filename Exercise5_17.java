/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 2
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment2;
import java.util.Scanner;

public class Exercise5_17 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // user input for number of lines
        System.out.print("Enter number of lines: ");
        int num = input.nextInt();
        
        // number of rows in pyramid == user input numb
        for (int i = 0; i < num; i++) {
            
            // prints spaces before first num in the row 
            // if num = 7, 6 spaces will be printed 
            for (int j = 0; j < num - i; j++) {
                System.out.print("  ");
            }
            
            // prints the descending numbers of row with a space 
            // until 1 is printed
            for (int j = i + 1; j >= 1; j--) {
                System.out.print(j + " ");   
            }
            
            // prints the ascending numbers of row with a space
            // until the max for that row (i + 1) is reached
            for (int j = 2; j <= i + 1; j++) {
                System.out.print(j + " ");   
            }
            // 'moves' to next pyramid row
            System.out.println();
           
        }
    }
    
}
