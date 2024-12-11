package com.uum;

import java.util.Date;

/**
 * Test class for Library Management System.
 * Focuses on testing the main logic of the system, including books, seats, notifications, and user interactions.
 */
public class LibraryManagementTest {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books to the library
        Book book1 = new Book("B001", "1984", "George Orwell", "Fiction");
        Book book2 = new Book("B002", "Brave New World", "Aldous Huxley", "Science Fiction");
        library.addBook(book1);
        library.addBook(book2);

        // Add seats to the library
        Seat seat1 = new Seat("S001", 1);
        Seat seat2 = new Seat("S002", 1);
        library.addSeat("S001", seat1);
        library.addSeat("S002", seat2);

        // Create admin and library user
        Admin admin = new Admin("A001", "Admin User", "admin@library.com", "admin123");
        LibraryUser user = new LibraryUser("U001", "Library User", "user@library.com", "user123");

        // Admin adds a notification
        Notification notification = new Notification("N001", "Library Closed", "The library will be closed tomorrow.", admin.getUserID());
        admin.publishNotification(notification, library);

        // Display notifications
        library.displayNotifications();

        // User borrows a book
        System.out.println("\n=== Borrowing Books ===");
        user.borrowBook("B001", library);
        user.borrowBook("B002", library);

        // Attempt to borrow an already borrowed book
        user.borrowBook("B001", library);

        // Return a book
        System.out.println("\n=== Returning Books ===");
        user.returnBook("B001", library);
        user.returnBook("B003", library); // Non-existent book

        // Reserve seats
        System.out.println("\n=== Reserving Seats ===");
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000); // 1 hour later
        user.reserveSeat("S001", startTime, endTime, library);

        // Attempt to reserve an already reserved seat
        user.reserveSeat("S001", startTime, endTime, library);

        // Release seat
        System.out.println("\n=== Releasing Seats ===");
        seat1.releaseSeat(user.getUserID());
        seat2.releaseSeat(user.getUserID()); // Seat not reserved by this user

        // Check expired seat release
        seat1.releaseExpiredReservations();

        // Display the status of books and seats
        System.out.println("\n=== Final Library Status ===");
        System.out.println("Book 1 Borrowed: " + book1.isBorrowed());
        System.out.println("Book 2 Borrowed: " + book2.isBorrowed());
        System.out.println("Seat 1 Reserved: " + seat1.isReserved());
        System.out.println("Seat 2 Reserved: " + seat2.isReserved());
    }
}


