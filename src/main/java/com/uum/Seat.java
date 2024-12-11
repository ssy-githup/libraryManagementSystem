package com.uum;

import lombok.Data;

/**
 * Class Seat
 * Represents a library seat that can be reserved by users.
 * Implements the ISeatActions interface to define seat-related behaviors.
 */
@Data
public class Seat {
    private String seatID; // Unique ID for the seat.
    private int floorNum; // Floor number where the seat is located.
    private boolean isReserved; // Indicates if the seat is reserved.
    private String reservedBy; // The ID of the user who reserved the seat.

    /**
     * Constructs a Seat object with the specified seat ID and floor number.
     * @param seatID The unique ID of the seat.
     * @param floorNum The floor number where the seat is located.
     */
    public Seat(String seatID, int floorNum) {
        this.seatID = seatID;
        this.floorNum = floorNum;
        this.isReserved = false;
        this.reservedBy = null;
    }

    /**
     * Reserves the seat for a specified user.
     * @param userID The ID of the user reserving the seat.
     * @return True if the reservation is successful, false otherwise.
     */
    public boolean reserveSeat(String userID) {
        if (!isReserved) {
            isReserved = true;
            reservedBy = userID;
            System.out.println("Seat reserved successfully by user: " + userID);
            return true;
        }
        System.out.println("Seat is already reserved: " + seatID);
        return false;
    }
    /**
     * Releases the reservation for the seat.
     * @param userID The ID of the user releasing the seat.
     * @return True if the seat is successfully released, false otherwise.
     */
    public boolean releaseSeat(String userID) {
        if (isReserved && reservedBy.equals(userID)) {
            isReserved = false;
            reservedBy = null;
            System.out.println("Seat released successfully by user: " + userID);
            return true;
        }
        System.out.println("Seat was not reserved by user: " + userID);
        return false;
    }
    /**
     * Releases the reservation if the reservation has expired or needs to be cleared.
     */
    public void releaseExpiredReservations() {
        if (isReserved) {
            isReserved = false;
            reservedBy = null;
            System.out.println("Expired reservation released for seat: " + seatID);
        }
    }

    /**
     * Checks if the seat is reserved.
     * @return True if the seat is reserved, false otherwise.
     */
    public boolean isReserved() {
        return isReserved;
    }

}
