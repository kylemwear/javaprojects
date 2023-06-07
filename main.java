/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Program 4
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package program4;

import barchart.BarChartFrame;
import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // set up array size 
        int arraySize = 0;

        /**
         * FIRST USER INPUT
         */
        // catches mismatched inputs and will loop until there's no error
        while (true) {
            try {
                System.out.println("How many numbers in the array?");
                arraySize = input.nextInt();
                break;
            } catch (InputMismatchException error) {
                System.out.println("Please try again: " + error.toString());
                input.nextLine();
            }
        }
        double[] array = new double[arraySize];

        /**
         * SECOND USER INPUT
         *
         */
        // catches mismatched inputs and will loop until there's no error
        while (true) {
            try {
                // assigns user values to array
                System.out.println("Please enter " + arraySize + " numbers");
                for (int i = 0; i < array.length; i++) {
                    array[i] = input.nextDouble();
                }
                break;
            } catch (InputMismatchException error) {
                System.out.println("Please try again: " + error.toString());
                input.nextLine();
            }
        }

        // condition for while loop to continue
        boolean quit = false;

        /**
         * ENTIRE MENU LOOP
         */
        // I encapsulated the entire menu loop section in a try catch to 
        // xcatch exceptions and allow the user to try again
        while (true) {
            try {

                while (quit == false) {
                    System.out.println("\nEnter: \n"
                            + "1 -- to determine if a number is prime\n"
                            + "2 -- to list prime numbers below a given value\n"
                            + "3 -- to compute the statistics from an array of numbers\n"
                            + "4 -- to perform linear search finding a number in the array\n"
                            + "5 -- to display a bar chart of values\n"
                            + "0 -- to quit\n");
                    int choice = input.nextInt();

                    // user picks an option and switch-case calls appropriate method and 
                    // displays output
                    switch (choice) {

                        case 1:
                            // uses isPrime() and an if-else to print
                            System.out.print("Enter a number: ");
                            int primeTest = input.nextInt();
                            if (isPrime(primeTest)) {
                                System.out.println(primeTest + " IS a prime number");
                            } else {
                                System.out.println(primeTest + " is NOT a prime number");
                            }
                            break;

                        case 2:
                            // uses listPrimes() to print prime numbers 
                            System.out.print("Enter a number: ");
                            int primeList = input.nextInt();
                            System.out.print(listPrimes(primeList));
                            break;

                        case 3:
                            // for loop to print contents of array then uses average()
                            System.out.print("The average of: ");
                            for (int i = 0; i < array.length; i++) {
                                System.out.print(" " + array[i]);
                            }
                            System.out.print(" is " + average(array));

                            // and standardDeviation()
                            System.out.print("\nThe standard deviation of: ");
                            for (int i = 0; i < array.length; i++) {
                                System.out.print(" " + array[i]);
                            }
                            System.out.print(" is " + standardDeviation(array) + "\n");
                            break;

                        case 4:
                            // uses linearSearch() and an if-else based on what's returned to print
                            System.out.print("Enter a double value: ");
                            double searchNum = input.nextDouble();
                            if (linearSearch(array, searchNum) == -1) {
                                System.out.print("The value " + searchNum + " is not in the array ");
                            } else {
                                System.out.print("The value " + searchNum + " is in "
                                        + "the array at position " + linearSearch(array, searchNum) + "\n");
                            }
                            break;

                        case 5:
                            // uses displayBarChart
                            displayBarChart(array);
                            break;

                        case 0:
                            // quits program with goodbye message
                            System.out.print("Goodbye!");
                            quit = true;
                            /**
                             * without the code below I couldn't select any more
                             * choices after displaying the barChart. Ex: enter
                             * an array with 1 2 3 and select option 5. the
                             * barchart will display, but I can no longer select
                             * average or exit if I wanted to *
                             */
                            System.exit(0);
                            break;
                    }

                }
                break;
            } catch (InputMismatchException error) {
                System.out.println("Please try again: " + error.toString());
                input.nextLine();
            }
        }
    }

    static boolean isPrime(int number) {
        // starts at 2 and goes to half of the number while testing for 
        // a remainder to see if it's prime or not
        for (int i = 2; i <= number * .5; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static String listPrimes(int number) {
        // uses isPrime() to find prime numbers less than number
        String list = "The prime numbers leading up to " + number + " are: ";
        int count = 0;
        for (int i = 1; i < number; i++) {
            if (isPrime(i)) {
                list += " " + i;
                count++;
            }
            // uses count to keep track of values per line in the output
            // when it reaches 10. a newline is concatenated and count is reset
            if (count == 10) {
                list += "\n";
                count = 0;
            }
        }
        return list;
    }

    static double average(double[] nbrs) {
        // sums up values in the array and divides by how many there are
        double average = 0;
        double sum = 0;
        for (int i = 0; i < nbrs.length; i++) {
            sum += nbrs[i];
            average = sum / (nbrs.length);
        }
        return average;
    }

    static double standardDeviation(double[] nbrs) {
        // uses std deviation formula and average()  
        double sum = 0;
        for (int i = 0; i < nbrs.length; i++) {
            // this represents the numerator in the formula
            // sum(x - u)^2
            sum += Math.pow(nbrs[i] - average(nbrs), 2);
        }
        // represents the denominator and rest of formular
        // divides numerator by (N - 1) and then square roots the whole thing
        double standardDev = Math.sqrt((sum) / (nbrs.length - 1));
        return standardDev;
    }

    public static int linearSearch(double[] list, double value) {
        // for loop to search through array
        for (int i = 0; i < list.length; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    static void displayBarChart(double[] values) {
        // creates arrays of the same length 
        int[] nbrs = new int[values.length];
        String[] labels = new String[values.length];
        String[] info = new String[values.length];
        String lowHi;

        for (int i = 0; i < values.length; i++) {
            // puts values and casts them as ints also creates bar labels
            nbrs[i] = (int) values[i];
            labels[i] = "Bar " + i;

            // assigns correct description to bars using average()
            if (values[i] > average(values)) {
                lowHi = "Greater than average";
            } else if (values[i] > average(values)) {
                lowHi = "Lower than average";
            } else {
                lowHi = "Equal to average";
            }
            info[i] = "Bar " + i + " value is " + values[i] + "\n" + lowHi;

        }
        new BarChartFrame("Array Values", nbrs, labels, info);
    }
}
