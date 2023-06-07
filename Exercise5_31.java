/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 2
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment2;
import java.util.Scanner;

public class Exercise5_31 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // gathers all user inputs
        System.out.print("Enter the initial deposit amount: ");
        double dep = input.nextDouble();
        
        System.out.print("Enter annual percentage yield: ");
        double apr = input.nextDouble();
        
        System.out.print("Enter maturity period (number of months): ");
        int mat = input.nextInt();
                    
        // prints header of list
        System.out.println("Month \t CD Value");
        
        // assigns the accumulating cd and prints it formatted
        // i is the months, cd is assigned to a higher value each loop
        for (int i = 1; i <= mat; i++) {
            double cd = dep += dep * (apr / 1200);
            System.out.print(i + "\t"); 
            System.out.printf(" %.2f", cd);
            System.out.print("\n");          
        }
    }
    
}
