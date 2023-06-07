/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 2
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment2;
import java.util.Scanner;

public class Exercise5_41 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // user input
        System.out.print("Enter numbers: ");
        int max = input.nextInt();
        int count = 1;
        int nextNum = 1;
        
        // when 0 is entered, no more nums can be entered
        while (nextNum > 0){
            nextNum = input.nextInt();
            
            // assigns the highest value int that is entered to max
            // resets count to 0 for each new max that is entered
            if (nextNum > max) {
                max = nextNum;
                count = 0;
            }
            // adds 1 to the count of max is it is entered
            if (nextNum == max) {
                count++;
            }
        }
        
        System.out.println("The largest number is: " + max);
        System.out.println("The occurence of the largest number is " + count);
    }
    
}
