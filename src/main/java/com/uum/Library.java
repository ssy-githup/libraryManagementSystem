package com.uum;

import lombok.Data;

import java.util.*;

/**
 * Class Library
 * Represents the central management system of the library.
 * Manages books, seats, and notifications while coordinating interactions between users and resources.
 */
@Data
public class Library {
    private Map<String, Book> books; // Stores all books in the library, keyed by their unique ID.
    private Map<String, Seat> seats; // Stores all seats in the library, keyed by their unique ID.
    private List<Notification> notifications; // Stores all notifications published in the library.

    /**
     * Constructs a Library object with empty collections for books, seats, and notifications.
     */
    public Library() {
        this.books = new HashMap<>();
        this.seats = new HashMap<>();
        this.notifications = new ArrayList<>();
    }

    // --- Book Management Methods ---

    /**
     * Adds a book to the library collection.
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.put(book.getBookID(), book);
        System.out.println("Book added: " + book.getBookID());
    }

    /**
     * Removes a book from the library collection.
     * @param bookID The unique ID of the book to be removed.
     */
    public void removeBook(String bookID) {
        if (books.containsKey(bookID)) {
            books.remove(bookID);
            System.out.println("Book removed: " + bookID);
        } else {
            System.out.println("Book not found: " + bookID);
        }
    }

    /**
     * Allows a user to borrow a book from the library.
     * @param bookID The unique ID of the book to be borrowed.
     * @param userID The ID of the user borrowing the book.
     * @return True if the book is successfully borrowed, false otherwise.
     */
    public boolean borrowBook(String bookID, String userID) {
        if (books.containsKey(bookID)) {
            Book book = books.get(bookID);
            if (book.borrow()) {
                System.out.println("Book borrowed by user: " + userID);
                return true;
            } else {
                System.out.println("Book is already borrowed: " + bookID);
            }
        } else {
            System.out.println("Book not found: " + bookID);
        }
        return false;
    }

    /**
     * Allows a user to return a borrowed book to the library.
     * @param bookID The unique ID of the book to be returned.
     * @param userID The ID of the user returning the book.
     * @return True if the book is successfully returned, false otherwise.
     */
    public boolean returnBook(String bookID, String userID) {
        if (books.containsKey(bookID)) {
            Book book = books.get(bookID);
            if (book.returnBook()) {
                System.out.println("Book returned by user: " + userID);
                return true;
            } else {
                System.out.println("Book is not currently borrowed: " + bookID);
            }
        } else {
            System.out.println("Book not found: " + bookID);
        }
        return false;
    }

    // --- Seat Management Methods ---

    /**
     * Adds a seat to the library collection.
     * @param seatID The unique ID of the seat.
     * @param seat The seat object to be added.
     */
    public void addSeat(String seatID, Seat seat) {
        seats.put(seatID, seat);
        System.out.println("Seat added: " + seatID);
    }

    /**
     * Reserves a seat for a user during a specific time period.
     * @param seatID The unique ID of the seat to be reserved.
     * @param startTime The reservation start time.
     * @param endTime The reservation end time.
     * @param userID The ID of the user reserving the seat.
     * @return True if the seat is successfully reserved, false otherwise.
     */
    public boolean bookSeat(String seatID, Date startTime, Date endTime, String userID) {
        if (seats.containsKey(seatID)) {
            Seat seat = seats.get(seatID);
            if (seat.reserveSeat(userID)) {
                System.out.println("Seat reserved by user: " + userID);
                return true;
            } else {
                System.out.println("Seat is already reserved: " + seatID);
            }
        } else {
            System.out.println("Seat not found: " + seatID);
        }
        return false;
    }

    /**
     * Releases a reserved seat for a user.
     * @param seatID The unique ID of the seat to be released.
     * @param userID The ID of the user releasing the seat.
     * @return True if the seat is successfully released, false otherwise.
     */
    public boolean releaseSeat(String seatID, String userID) {
        if (seats.containsKey(seatID)) {
            Seat seat = seats.get(seatID);
            if (seat.releaseSeat(userID)) {
                System.out.println("Seat released by user: " + userID);
                return true;
            } else {
                System.out.println("Seat was not reserved by this user: " + userID);
            }
        } else {
            System.out.println("Seat not found: " + seatID);
        }
        return false;
    }

    // --- Notification Management Methods ---

    /**
     * Publishes a notification to the library system.
     * @param notification The notification to be published.
     */
    public void addNotification(Notification notification) {
        notifications.add(notification);
        System.out.println("Notification published: " + notification.getTitle());
    }

    /**
     * Displays all notifications published in the library.
     */
    public void displayNotifications() {
        System.out.println("Library Notifications:");
        for (Notification notification : notifications) {
            notification.display();
        }
    }

    public int getTotalBooks() {
        return books.size();
    }
}
