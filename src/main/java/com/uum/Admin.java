package com.uum;

import com.uum.abs.User;
import com.uum.impl.IUserActions;

/**
 * Class Admin
 * Represents an administrator who can manage books, seats, and notifications.
 * Extends the User class and inherits its properties and behaviors.
 */
public class Admin extends User {
    /**
     * Constructs an Admin object with specified details.
     * @param userID The admin's unique ID.
     * @param name The admin's name.
     * @param email The admin's email.
     * @param password The admin's password.
     */
    public Admin(String userID, String name, String email, String password) {
        super(userID, name, email, password);
    }

    /**
     * Adds a book to the library system.
     * @param book The book to be added.
     * @param library The library instance managing the books.
     */
    public void addBook(Book book, Library library) {
        library.addBook(book);
    }

    /**
     * Removes a book from the library system.
     * @param bookID The ID of the book to be removed.
     * @param library The library instance managing the books.
     */
    public void removeBook(String bookID, Library library) {
        library.removeBook(bookID);
    }

    /**
     * Publishes a notification to the library system.
     * @param notification The notification to be published.
     * @param library The library instance managing the notifications.
     */
    public void publishNotification(Notification notification, Library library) {
        library.addNotification(notification);
    }

    /**
     * Manages seat violations by releasing expired reservations.
     * @param seat The seat to be checked.
     */
    public void manageSeatUsage(Seat seat) {
        seat.releaseExpiredReservations();
    }
}
