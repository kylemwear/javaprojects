/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Program 6
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package Program5;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class UserApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (true) {
            try {

                while (quit == false) {
                    System.out.println("\nChoices are: \n"
                            + "(1) Read user file\n"
                            + "(2) Add new user\n"
                            + "(3) List Users\n"
                            + "(4) Display Information about a user\n"
                            + "(5) User Login\n"
                            + "(6) Add an admin user\n"
                            + "(7) List admin users\n"
                            + "(8) Write user file\n"
                            + "(9) Quit\n"
                            + "What is your choice? (1-9)");
                    int choice = input.nextInt();

                    // user picks an option and switch-case calls appropriate method and 
                    // displays output
                    switch (choice) {
                        // reads user file and adds to users array
                        case 1:
                            try {
                                File path = new File("C:\\Users\\kylem\\Downloads\\users.txt");
                                Scanner file = new Scanner(path);
                                while (file.hasNextLine()) {

                                    String next = file.nextLine();
                                    String[] items = next.split("\t");

                                    String first = items[0];
                                    String last = items[1];
                                    String id = items[2];
                                    String pass = items[3];

                                    User.addUser(first, last, id, pass, true);

                                }
                                System.out.println("\nFile read successfully");
                            } catch (FileNotFoundException e) {
                                System.out.println("Error finding file: " + e.toString());
                            }
                            break;

                        // gets input and adds User to array
                        case 2:
                            System.out.println("Enter the user's first name: ");
                            String first = input.next();
                            System.out.println("Enter the user's last name: ");
                            String last = input.next();
                            System.out.println("Enter the user id: ");
                            String id = input.next();
                            System.out.println("Enter the user password: ");
                            String pass = input.next();
                            if (User.addUser(first, last, id, pass, true)) {
                                System.out.println("User Added");
                            } else {
                                System.out.println("Error adding user");
                            }

                            break;

                        // lists the info on each User in array
                        case 3:
                            System.out.println("\nUser list");
                            System.out.println(User.listUsers());
                            break;

                        // searches for inputted user and returns appropriate result
                        case 4:
                            System.out.println("Enter the user first and last name to search for: ");
                            String name = input.next();
                            String name2 = input.next();
                            String fullName = name + " " + name2;
                            int num = User.findUser(fullName);

                            if (num == -1) {
                                System.out.println(fullName + " Not found");
                            } else {
                                User current = User.getUser(num);
                                System.out.println(current.userInfo(true));
                            }
                            break;

                        // attempts to login with inputted data and displays result
                        case 5:
                            System.out.println("Enter user id and password\n");
                            String entID = input.next();
                            String entPass = input.next();
                            System.out.println(User.userLogin(entID, entPass));
                            break;

                        // gets input and adds an AdminUser to array
                        case 6:
                            System.out.println("Enter the user's first name: ");
                            String aFirst = input.next();
                            System.out.println("Enter the user's last name: ");
                            String aLast = input.next();
                            System.out.println("Enter the user id: ");
                            String aId = input.next();
                            System.out.println("Enter the user password: ");
                            String aPass = input.next();
                            input.nextLine();
                            System.out.println("Enter the user permission(s) separated by a space: ");
                            String aPerm = input.nextLine();
                            if (AdminUser.addAdminUser(aFirst, aLast, aId, aPass, true, aPerm)) {
                                System.out.println("User Added");
                            } else {
                                System.out.println("Error adding user");
                            }

                            break;

                        // lists adminuser info
                        case 7:
                            System.out.println("Please enter permission to search by (database, cloud, security, any): ");
                            String type = input.next();
                            System.out.println("\nAdminUser list");
                            System.out.println(AdminUser.listAdminUsers(type));
                            break;

                        // writes current user data into a new txt file
                        case 8:
                            try {
                                File newFile = new File("C:\\Users\\kylem\\Downloads\\newUsers.txt");
                                FileWriter writer = new FileWriter(newFile);
                                for (int i = 0; i < User.getTotUsers(); i++) {
                                    writer.write(User.getUser(i).getFirstName()
                                            + "\t" + User.getUser(i).getLastName()
                                            + "\t" + User.getUser(i).getUserID()
                                            + "\t" + User.getUser(i).getPassword() + "\n");
                                }
                                writer.close();
                                System.out.println("User file written");
                            } catch (IOException e) {
                                System.out.println("Error writing to file: " + e);
                            }
                            break;
                            
                        // quits program
                        case 9:
                            System.out.print("Goodbye!");
                            quit = true;
                            System.exit(0);
                            break;
                    }

                }
                break;
                // catches input errors
            } catch (InputMismatchException error) {
                System.out.println("Please try again: " + error.toString());
                input.nextLine();
            }

        }
    }
}
