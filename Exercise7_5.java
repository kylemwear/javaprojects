/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 2
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment2;
import java.util.Scanner;

public class Exercise7_5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // prompts user and initializes an array and variables
        System.out.print("Enter 10 Numbers: ");
        int[] numbers = new int[10];
        int num;
        int count = 0;
        boolean distinct;
               
        // assigns values to the array
        for (int i = 0; i < numbers.length; i++) {
            num = input.nextInt();
            distinct = false;
            // checks if the entered num is distinct from other nums
            // if true, adds it to the array
            for (int j = 0; j < numbers.length; j++) {
                if (num == numbers[j]) {
                    distinct = true;
                }
            }
            // if false, increases the count for that num
            if (!distinct) {
                numbers[count++] = num;                
            }           
        }    
        
        System.out.println("The number of distinct number is " + count);
        System.out.print("The distinct numbers are: ");
        
        // prints the distinct numbers in order of entry/when they were 
        // assigned to array
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i] + " ");
        }
        
        System.out.println();
        
    }
    
}
