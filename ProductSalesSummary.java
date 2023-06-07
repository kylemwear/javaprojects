/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Assignment 3
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package assignment3;
import java.io.File;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class ProductSalesSummary {
    public static void main(String[] args) {       
        try {
            // scanner, file, and numberformat instantiation
            Scanner input = new Scanner(System.in);
            System.out.print("Enter full path of input file: ");
            File path = new File(input.nextLine());
            Scanner file = new Scanner(path);
            NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
            
            String[] productNames = new String[100];
            int[] totalUnits = new int[100];
            double[] revenuesPerProduct = new double[100];
            String[] regions = {"North", "South", "East", "West"};
            double[] regionalRevenue = new double[100];
            int totalProducts = 0;
                   
            // reads each line and adds/stores/manipulates data 
            while (file.hasNextLine()) { 
                // uses split method to separate the line into 5 items
                // separates by tabs
                String next = file.nextLine();
                String[] items = next.split("\t");
                
                // goes through the items array and assigns values 
                String name = items[0];
                double price = Double.parseDouble(items[1]);
                int north = Integer.parseInt(items[2]);
                int south = Integer.parseInt(items[3]);
                int east = Integer.parseInt(items[4]);
                int west = Integer.parseInt(items[5]);

                productNames[totalProducts] = name;
                totalUnits[totalProducts] = north + south + east + west;
                revenuesPerProduct[totalProducts] = totalUnits[totalProducts] * price;
                
                // adds up and stores revenue per region
                regionalRevenue[0] += north * price;
                regionalRevenue[1] += south * price;
                regionalRevenue[2] += east * price;
                regionalRevenue[3] += west * price;
                
                // adds 1 to be used for the next line
                totalProducts++;
            }
            
            // totals and average
            double grandTotal = 0;
            int grandTotalUnits = 0;
            double averageRevenue = 0;
            int aboveAverage = 0;
            
            for (int i = 0; i < totalProducts; i++) {
                grandTotal += revenuesPerProduct[i];
                grandTotalUnits += totalUnits[i];
            }
            
            averageRevenue = grandTotal / totalProducts;
            
            
            // outputs
            System.out.println("\nRevenue by Region\n");
            for (int i = 0; i < 4; i++) {
                System.out.print(regions[i] + "\t" + 
                        currency.format(regionalRevenue[i]) + "\n");
            }
            System.out.print("Total revenue: " + currency.format(grandTotal));
            System.out.print("\n\nProduct Summary\nProduct Type\t Units\t Revenue\n");
            for (int i = 0; i < totalProducts; i++) {
                System.out.print(productNames[i] + ":\t  " + totalUnits[i] + "\t" 
                        + currency.format(revenuesPerProduct[i]) + "\n");
            }
            
            System.out.print("\nGRAND TOTAL:\t " + grandTotalUnits + "\t" + currency.format(grandTotal));
            System.out.print("\nAVERAGE REVENUE:\t" + currency.format(averageRevenue));
            
            System.out.print("\n\nThese products generated higher than the average revenue:\n");
            for (int i = 0; i < 100; i++) {
                if (revenuesPerProduct[i] > averageRevenue) {
                    System.out.print("\t" + productNames[i] + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error finding file: " + e.toString());
        }
    }
    
}
