/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program5;

/**
 *
 * @author kylem2
 */
public class AdminUser extends User {
    private String permission;
    
    // default constructor
    public AdminUser() {
        super();
        permission = "";
    }
    
    // overloaded constructor
    public AdminUser(String first, String last, String id, String pass, String perm) {
        super(first, last, id, pass);
        setPermission(perm);
    }
    
    // sets permission to acceptable options
    public void setPermission(String perm) {
        permission = "";
        String[] perms = perm.split(" ");
        for (int i = 0; i < perms.length; i++) {
            if (perms[i].equalsIgnoreCase("database")) {
                permission += "database ";
            } else if (perms[i].equalsIgnoreCase("cloud")) {
                permission += "cloud ";
            } else if (perms[i].equalsIgnoreCase("security")) {
                permission += "security ";
            } 
        }
        
    }
    
    // returns permission
    public String getPermission() {
        return permission;
    }
    
    // overridden toString 
    @Override
    public String toString() {
        return "Admin User";
    }
    
    // overridden userInfo
    @Override
    public String userInfo(boolean valid) {
        if (valid) {
            return super.userInfo(true) + "\nPermission: " + getPermission();
        } else {
            return super.userInfo(false);
        }
    }
    
    // add an AdminUser to users array
    public static boolean addAdminUser(String first, String last, String id, String pass, boolean hash, String perm) {
        if (users[MAXUSERS - 1] != null) {
            return false;
        } else {
            users[totUsers] = new AdminUser(first, last, id, pass, perm);
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
    
    // list admin user info and permissions
    public static String listAdminUsers(String type) {
        String list = "";
        for (int i = 0; i < totUsers; i++) {
            if (users[i] instanceof AdminUser) {
                if (type.equalsIgnoreCase("any")) {
                    list += "User: " + users[i].getFirstName() + " " 
                            + users[i].getLastName() + "\nPermission: " 
                            + ((AdminUser)users[i]).getPermission() + "\n";
                }
                if (((AdminUser)users[i]).getPermission().contains(type)) {
                    list += "User: " + users[i].getFirstName() + " " 
                            + users[i].getLastName() + "\nPermission: " 
                            + ((AdminUser)users[i]).getPermission() + "\n";
                }
            }
        }
        return list;
    }
}
