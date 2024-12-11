package com.uum;

import com.uum.impl.IBookActions;
import lombok.Data;

/**
 * Class Book
 * Represents a book in the library.
 * Implements the IBookActions interface to define book-related behaviors.
 */
@Data
public class Book implements IBookActions {
    private String bookID; // Unique ID of the book.
    private String title; // Title of the book.
    private String author; // Author of the book.
    private String genre; // Genre or category of the book.
    private boolean isBorrowed; // Indicates whether the book is currently borrowed.

    /**
     * Constructs a Book object with the specified details.
     * @param bookID The unique ID of the book.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param genre The genre or category of the book.
     */
    public Book(String bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = false; // Initially, the book is not borrowed.
    }

    /**
     * Allows a user to borrow the book.
     * @return True if the book is successfully borrowed, false if it is already borrowed.
     */
    @Override
    public boolean borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed successfully: " + title);
            return true;
        } else {
            System.out.println("Book is already borrowed: " + title);
            return false;
        }
    }

    /**
     * Allows a user to return the book.
     * @return True if the book is successfully returned, false if it was not borrowed.
     */
    @Override
    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned successfully: " + title);
            return true;
        } else {
            System.out.println("Book was not borrowed: " + title);
            return false;
        }
    }

    /**
     * Allows a user to renew the borrowed book.
     * @return True if the book is successfully renewed, false if it was not borrowed.
     */
    @Override
    public boolean renew() {
        if (isBorrowed) {
            System.out.println("Book renewed successfully: " + title);
            return true;
        } else {
            System.out.println("Book is not currently borrowed: " + title);
            return false;
        }
    }

    /**
     * Checks if the book is currently borrowed.
     * @return True if the book is borrowed, false otherwise.
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }

    /**
     * Sets the borrowed status of the book.
     * @param borrowed True to mark the book as borrowed, false otherwise.
     */
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
