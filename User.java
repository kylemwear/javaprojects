/*
 * Kyle Wear 112722971
 * CIS 331 Section 2
 * Program 6
 * I have neither given nor received any unauthorized 
 * assistance on this assignment
 */
package Program5;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

class User {

    private String firstName, lastName, userID;
    protected String password;

    // used in isValidPassword() and setUserID()
    private String specialChar = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";

    protected static final int MAXUSERS = 4;
    protected static User[] users = new User[MAXUSERS];
    protected static int totUsers = 0;

    // default constructor
    public User() {
        firstName = "FIRST";
        lastName = "LAST";
        userID = "Unknown";
        password = "Unknown";
    }

    // overloaded constructor
    public User(String first, String last, String id, String pass) {
        setFirstName(first);
        setLastName(last);
        setUserID(id);
        setPassword(pass, true);
    }

    // sets first name with correct capitalization 
    public void setFirstName(String first) {
        String newFirst = "";
        char[] firstArray = first.toCharArray();

        for (int i = 0; i < firstArray.length; i++) {
            if (i == 0) {
                firstArray[i] = Character.toUpperCase(firstArray[i]);
            } else {
                firstArray[i] = Character.toLowerCase(firstArray[i]);
            }
            newFirst += firstArray[i];
        }
        firstName = newFirst;
    }

    // returns first name
    public String getFirstName() {
        return firstName;
    }

    // sets last name with correct capitalization
    public void setLastName(String last) {
        String newLast = "";
        char[] lastArray = last.toCharArray();

        for (int i = 0; i < lastArray.length; i++) {
            if (i == 0) {
                lastArray[i] = Character.toUpperCase(lastArray[i]);
            } else {
                lastArray[i] = Character.toLowerCase(lastArray[i]);
            }
            newLast += lastArray[i];
        }

        lastName = newLast;
    }

    // returns last name
    public String getLastName() {
        return lastName;
    }

    /* 
     Sets userID if first char is a letter, it doesn't contain spaces,
     and has no special characters. Otherwise, userID = Unknown
     */
    public void setUserID(String id) {

        char[] idArray = id.toCharArray();

        for (int i = 0; i < idArray.length; i++) {
            if (!Character.isLetter(idArray[0])) {
                userID = "Unknown";
                break;
            } else if (idArray[i] == ' ') {
                userID = "Unknown";
                break;
            } else if (specialChar.contains(Character.toString(idArray[i]))) {
                userID = "Unknown";
                break;
            } else {
                userID = id;
            }
        }

    }

    // returns userID
    public String getUserID() {
        return userID;
    }

    /*
     Sets password as a hashed version or as unknown using isValidPassword()
     */
    public void setPassword(String pass, boolean hash) {
        try {
            if (isValidPassword(pass)) {
                if (hash) {
                    password = GFG2.toHexString(GFG2.getSHA(pass));
                } else if (!hash) {
                    password = pass;
                }
            } else {
                password = "Unknown";
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Oops, something went wrong :( " + e.toString());
        }
    }

    // returns password
    public String getPassword() {
        return password;
    }

    /*
     If parameter is true, returns all of the user info
     If false, returns only first and last name
     */
    public String userInfo(boolean bool) {
        String info;
        if (bool) {
            info = "First Name: " + getFirstName() + "\nLast Name: " + getLastName()
                    + "\nUserID: " + getUserID() + "\nPassword: " + getPassword()
                    + "\nType: " + this.toString();
        } else {
            info = "First Name: " + getFirstName() + "\nLast Name: " + getLastName()
                    + "\nType: " + this.toString();
        }
        return info;
    }

    // checks if parameter and current user object's names are equals
    public boolean equals(String name) {
        boolean isEqual = name.equalsIgnoreCase(getFirstName() + " " + getLastName());
        return isEqual;
    }

    /*
     Checks for at least one uppercase letter, lowercase letter,
     number, and special character as well as no spaces 
     */
    public boolean isValidPassword(String pass) {
        boolean valid = false, charIsUp = false, charIsLow = false,
                hasNum = false, hasSpecial = false, hasSpace = false;

        char[] charArray = pass.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                charIsUp = true;
            }
            if (Character.isLowerCase(charArray[i])) {
                charIsLow = true;
            }
            if (Character.isDigit(charArray[i])) {
                hasNum = true;
            }
            if (specialChar.contains(Character.toString(charArray[i]))) {
                hasSpecial = true;
            }
            if (charArray[i] == ' ') {
                hasSpace = true;
            }
        }

        if (pass.length() >= 8 && charIsUp && charIsLow
                && hasNum && hasSpecial && !hasSpace) {
            valid = true;
        }
        return valid;
    }

    // lists each user and their info
    public static String listUsers() {
        String list = "";

        for (int i = 0; i < totUsers; i++) {
            list += ("\t" + users[i].toString() + " " + users[i].getFirstName() + " " + users[i].getLastName() + " "
                    + users[i].getUserID() + "\n");
        }
        return list;
    }

    // returns index of specified user
    public static int findUser(String firstAndLast) {
        int num = -1;
        for (int i = 0; i < totUsers; i++) {
            String name = users[i].getFirstName() + " " + users[i].getLastName();
            if (name.equalsIgnoreCase(firstAndLast)) {
                num = i;
            }
        }
        return num;
    }

    // adds a User to users array
    public static boolean addUser(String first, String last, String id, String pass, boolean hash) {

        if (users[MAXUSERS - 1] != null) {
            return false;
        } else {
            users[totUsers] = new User(first, last, id, pass);
            if (users[totUsers].isValidPassword(pass)) {
                hash = true;
            } else {
                hash = false;
            }

            users[totUsers].setPassword(pass, hash);
            totUsers++;
            return true;
        }

    }

    // returns reference to user at index i
    public static User getUser(int i) {
        return users[i];
    }

    // attempts a login and returns appropriate result
    public static String userLogin(String id, String pass) throws NoSuchAlgorithmException {
        String result = "";
        boolean found;
        boolean valid;
        int userInt;

        for (int i = 0; i < totUsers; i++) {
            if (!users[i].isValidPassword(pass)) {
                result = pass + " isn't a valid password";
                valid = false;
                break;
            } else {
                valid = true;
            }
            if (id.equals(users[i].getUserID())) {
                found = true;
                userInt = i;
            } else {
                result = id + " does not exist";
                break;
            }

            if (found && valid) {
                try {
                    String hashed = GFG2.toHexString(GFG2.getSHA(pass));
                    pass = hashed;
                } catch (NoSuchAlgorithmException e) {
                    System.out.println(e.toString());
                }
                if (users[userInt].getPassword().equals(pass)) {
                    result = "Login Successful for User: " + users[userInt].getFirstName()
                            + " " + users[userInt].getLastName();
                } else {
                    result = "UserID and Password do not match";
                }
            }
        }
        return result;

    }

    // returns totUsers
    public static int getTotUsers() {
        return totUsers;
    }

    @Override
    public String toString() {
        return "User";
    }
}
