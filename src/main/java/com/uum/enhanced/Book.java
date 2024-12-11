package com.uum.enhanced;

public class Book {
    private String bookID;
    private String title;
    private String genre;
    private String author;
    private boolean isBorrowed;

    public Book(String bookID, String title, String genre, String author) {
        this.bookID = bookID;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.isBorrowed = false;
    }

    // Synchronized method to borrow a book with validation
    public synchronized boolean borrow(String userID) {
        if (!isBorrowed) {
            isBorrowed = true;
            return true; // Successfully borrowed
        }
        return false; // Already borrowed
    }

    // Synchronized method to return a book
    public synchronized boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            return true; // Successfully returned
        }
        return false; // Book was not borrowed
    }

    // Getters
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Overridden methods
    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return bookID.equals(book.bookID);
    }

    @Override
    public int hashCode() {
        return bookID.hashCode();
    }
}
