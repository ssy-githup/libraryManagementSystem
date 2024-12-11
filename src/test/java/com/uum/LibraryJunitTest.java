package com.uum;




import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class LibraryJunitTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Seat seat1;
    private Admin admin;
    private LibraryUser user;

    @Before
    public void setup() {
        // Initialize library
        library = new Library();

        // Initialize books
        book1 = new Book("B001", "1984", "George Orwell", "Fiction");
        book2 = new Book("B002", "Brave New World", "Aldous Huxley", "Fiction");

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);

        // Initialize seat
        seat1 = new Seat("S001", 1);

        // Add seat to library
        library.addSeat("S001", seat1);

        // Initialize users
        admin = new Admin("A001", "Admin User", "admin@library.com", "admin123");
        user = new LibraryUser("U001", "Library User", "user@library.com", "user123");
        System.out.println("-----------------------------------------------------");
    }

    @Test
    public void testAddAndRemoveBook() {
        // Add a book
        Book book3 = new Book("B003", "Animal Farm", "George Orwell", "Fiction");
        library.addBook(book3);
        assertEquals(3, library.getTotalBooks());

        // Remove a book
        library.removeBook("B001");
        assertEquals(2, library.getTotalBooks());
        System.out.println("-----------------------------------------------------");
    }

    @Test
    public void testBorrowAndReturnBook() {
        // Borrow a book
        assertTrue(library.borrowBook("B001", "U001"));
        assertTrue(book1.isBorrowed());

        // Return the book
        assertTrue(library.returnBook("B001", "U001"));
        assertFalse(book1.isBorrowed());

        // Try returning a book that is not borrowed
        assertFalse(library.returnBook("B002", "U001"));
        System.out.println("-----------------------------------------------------");
    }

    @Test
    public void testSeatReservation() {
        // Reserve a seat
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000); // 1 hour later
        assertTrue(library.bookSeat("S001", startTime, endTime, user.getUserID()));

        // Attempt to reserve an already reserved seat
        assertFalse(library.bookSeat("S001", startTime, endTime, "U002"));

        // Release the seat
        assertTrue(seat1.releaseSeat(user.getUserID()));

        // Attempt to release a seat not reserved by the user
        assertFalse(seat1.releaseSeat("U002"));
        System.out.println("-----------------------------------------------------");
    }

    @Test
    public void testNotificationPublishing() {
        // Admin publishes a notification
        Notification notification = new Notification("N001", "Library Closed", "The library will be closed tomorrow.", admin.getUserID());
        admin.publishNotification(notification, library);

        // Verify notification is added to library
        assertEquals(1, library.getNotifications().size());
        assertEquals("Library Closed", library.getNotifications().get(0).getTitle());
    }
}