package com.uum;

import java.util.Date;

/**
 * Class Notification
 * Represents a notification published by the library administrator.
 * Implements the INotificationActions interface to define notification-related behaviors.
 */
public class Notification {
    private String notificationID; // Unique ID for the notification.
    private String title; // Title of the notification.
    private String content; // Content or message of the notification.
    private Date timestamp; // Timestamp when the notification was created.
    private String publishedBy; // The ID of the administrator who published the notification.

    /**
     * Constructs a Notification object with specified details.
     * @param notificationID The unique ID of the notification.
     * @param title The title of the notification.
     * @param content The content or message of the notification.
     * @param publishedBy The ID of the administrator who published the notification.
     */
    public Notification(String notificationID, String title, String content, String publishedBy) {
        this.notificationID = notificationID;
        this.title = title;
        this.content = content;
        this.timestamp = new Date(); // Sets the timestamp to the current date and time.
        this.publishedBy = publishedBy;
    }

    /**
     * Displays the details of the notification.
     */
    public void display() {
        System.out.println("Notification ID: " + notificationID);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Published By: " + publishedBy);
        System.out.println("Timestamp: " + timestamp);
    }

    // Getters for notification attributes

    /**
     * Gets the notification ID.
     * @return The unique ID of the notification.
     */
    public String getNotificationID() {
        return notificationID;
    }

    /**
     * Gets the title of the notification.
     * @return The title of the notification.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the content of the notification.
     * @return The content of the notification.
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the timestamp of the notification.
     * @return The timestamp when the notification was created.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the ID of the administrator who published the notification.
     * @return The ID of the publisher.
     */
    public String getPublishedBy() {
        return publishedBy;
    }
}
