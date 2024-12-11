package com.uum.impl;

/**
 * Interface IUserActions
 * Defines the basic actions that a user can perform.
 * All classes implementing this interface must implement these methods.
 */
public interface IUserActions {
    /**
     * Logs the user into the system.
     * @param email The user's email address.
     * @param password The user's password.
     * @return True if the login is successful, false otherwise.
     */
    boolean login(String email, String password);

    /**
     * Logs the user out of the system.
     */
    void logout();

    /**
     * Updates the user's profile information.
     * @param newEmail The new email address for the user.
     * @param newName The new name for the user.
     */
    void updateProfile(String newEmail, String newName);
}
