package com.uum.abs;

import com.uum.impl.IUserActions;
import lombok.Data;

/**
 * Abstract class User
 * Represents the base class for all users in the library system.
 * Implements the IUserActions interface to define user-related actions.
 */
@Data
public abstract class User implements IUserActions {
    private String userID; // Unique ID for the user.
    private String name; // Name of the user.
    private String email; // Email address of the user.
    private String password; // Password for user authentication.
    private boolean accountStatus; // Account status (active or inactive).

    /**
     * Constructs a User object with specified details.
     * @param userID The user's unique ID.
     * @param name The user's name.
     * @param email The user's email.
     * @param password The user's password.
     */
    public User(String userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountStatus = true; // Default account status is active.
    }

    @Override
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    @Override
    public void logout() {
        System.out.println("User logged out.");
    }

    @Override
    public void updateProfile(String newEmail, String newName) {
        this.email = newEmail;
        this.name = newName;
    }
}
