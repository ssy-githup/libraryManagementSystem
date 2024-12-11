package com.uum;

import com.uum.abs.User;
import lombok.Data;

import java.util.Date;

/**
 * Class LibraryUser
 * Represents a library user who can borrow books and reserve seats.
 * Extends the User class and inherits its properties and behaviors.
 */

public class LibraryUser extends User {
    /**
     * Constructs a LibraryUser object with specified details.
     * @param userID The user's unique ID.
     * @param name The user's name.
     * @param email The user's email.
     * @param password The user's password.
     */
    public LibraryUser(String userID, String name, String email, String password) {
        super(userID, name, email, password);
    }

    /**
     * Borrows a book from the library.
     * @param bookID The ID of the book to borrow.
     * @param library The library instance managing the books.
     */
    public boolean borrowBook(String bookID, Library library) {
       return library.borrowBook(bookID, this.getUserID());
    }

    /**
     * Returns a borrowed book to the library.
     * @param bookID The ID of the book to return.
     * @param library The library instance managing the books.
     */
    public void returnBook(String bookID, Library library) {
        library.returnBook(bookID, this.getUserID());
    }

    /**
     * Reserves a seat in the library.
     * @param seatID The ID of the seat to reserve.
     * @param startTime The reservation start time.
     * @param endTime The reservation end time.
     * @param library The library instance managing the seats.
     */
    public void reserveSeat(String seatID, Date startTime, Date endTime, Library library) {
        library.bookSeat(seatID, startTime, endTime, this.getUserID());
    }
}
