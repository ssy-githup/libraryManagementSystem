package com.uum.impl;

/**
 * Interface IBookActions
 * Defines the actions related to books, such as borrowing, returning, and renewing.
 */
public interface IBookActions {
    /**
     * Borrows a book.
     * @return True if the book is successfully borrowed, false otherwise.
     */
    boolean borrow();

    /**
     * Returns a book.
     * @return True if the book is successfully returned, false otherwise.
     */
    boolean returnBook();

    /**
     * Renews a borrowed book.
     * @return True if the renewal is successful, false otherwise.
     */
    boolean renew();
}
