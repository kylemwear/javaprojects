/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 1
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment1;

import java.util.Scanner;

public class Exercise3_11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // gets year and month from user
        System.out.print("Enter a month and year: ");
        int month = input.nextInt();
        int year = input.nextInt();
        int days = 0;
        
        /* switch based on what month the user enteres
         * for every month except for February (2),
         * the days stay the same regardless of year
         * to see if february should output 28 or 29
         * it tests if the remainder of the year divided by 4 is 0
         * if true, outputs 29, if false outputs 28
         */
        switch (month) {
            case 1: days = 31;
                    break;
            case 2: if ((year % 4) == 0) {
                    days = 29;
                    break;
            }
                    days = 28;
                    break;
            case 3: days = 31;
                    break;
            case 4: days = 30;
                    break;
            case 5: days = 31;
                    break;
            case 6: days = 30;
                    break;
            case 7: days = 31;
                    break;
            case 8: days = 31;
                    break;
            case 9: days = 30;
                    break;
            case 10: days = 31;
                    break;
            case 11: days = 30;
                    break;
            case 12: days = 31;
                
        }
         System.out.print("The number of days in the month is: " + days);
    }
    
}
