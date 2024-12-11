package com.uum.enhanced;



public class Seat {
    private int floorNum;
    private String seatID;
    private boolean isReserved;
    private String reservedBy;

    public Seat(String seatID, int floorNum) {
        this.seatID = seatID;
        this.floorNum = floorNum;
        this.isReserved = false;
        this.reservedBy = null;
    }

    // Synchronized method to ensure thread safety for reserving a seat
    public synchronized boolean reserveSeat(String userID) {
        if (!isReserved) {
            isReserved = true;
            reservedBy = userID;
            return true; // Successfully reserved
        }
        return false; // Already reserved
    }

    // Synchronized method to release a seat
    public synchronized boolean releaseSeat(String userID) {
        if (isReserved && reservedBy.equals(userID)) {
            isReserved = false;
            reservedBy = null;
            return true; // Successfully released
        }
        return false; // Not reserved by this user or already free
    }

    public synchronized void releaseExpiredReservations() {
        // Placeholder for additional logic to release expired reservations
        isReserved = false;
        reservedBy = null;
    }

    // Getters
    public String getSeatID() {
        return seatID;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    // Overridden methods
    @Override
    public String toString() {
        return "Seat{" +
                "seatID='" + seatID + '\'' +
                ", floorNum=" + floorNum +
                ", isReserved=" + isReserved +
                ", reservedBy='" + reservedBy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Seat seat = (Seat) obj;
        return seatID.equals(seat.seatID);
    }

    @Override
    public int hashCode() {
        return seatID.hashCode();
    }
}
