/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 2
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment2;
import java.util.Scanner;

public class Exercise7_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int best = 0;
        
        // user input for num of students
        System.out.print("Enter the number of students: ");
        int students = input.nextInt();
        // array of scores with entered length
        int[] scores = new int[students];
        // string array for assigning grades
        String[] grades = new String[students];
        
        // gathers entered scores and assigns to the scores array
        // also finds the highest of the entered score with Math.max 
        System.out.print("Enter Student Scores: ");        
        for (int i = 0; i < students; i++) {
            scores[i] = input.nextInt();
            best = Math.max(best, scores[i]);   
        }
        
        // goes through each value in scores and assigns values into the 
        // matching grades array
        for (int i = 0; i < students; i++) {
            if (scores[i] >= best - 10) {
                grades[i] = "A";
            } else if (scores[i] >= best - 20) {
                grades[i] = "B";
            } else if (scores[i] >= best - 30) {
                grades[i] = "C";
            } else if (scores[i] >= best - 40) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }    
        
        // prints each students score and grade
        for (int i = 0; i < students; i++) {
            System.out.println("Student " + i + " score is " + scores[i]
                    + " and grade is " + grades[i]);
        }
                  
    }
    
}
