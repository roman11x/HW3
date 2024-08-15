package model;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    // A map to store staff members by their usernames
    private Map<String, StaffMember> users;

    // Constructor
    public UserDatabase() {
        this.users = new HashMap<>();
    }



    // Method to add a new user
    public void addUser(StaffMember user) {
        if (users.containsKey(user.getUsername())) {
            System.out.println("Username already exists.");
        } else {
            users.put(user.getUsername(), user);
            System.out.println("User added successfully.");
        }
    }

    // Method to authenticate a user
    public StaffMember authenticate(String username, String password) {
        StaffMember user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Authentication successful.");
            return user;
        } else {
            System.out.println("Authentication failed.");
            return null;
        }
    }

    // Method to remove a user by username
    public void removeUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to get a user by username
    public StaffMember getUser(String username) {
        return users.get(username);
    }

    // Method to update a user's password
    public void updateUserPassword(String username, String newPassword) {
        StaffMember user = users.get(username);
        if (user != null) {
            user.setPassword(newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}
