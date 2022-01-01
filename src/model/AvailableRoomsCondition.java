package model;

import java.util.Collection;
import java.util.Date;

public class AvailableRoomsCondition {
    public Date checkInDate;
    public Date checkOutDate;
    public Collection<IRoom> availableRooms;

    public AvailableRoomsCondition(Date checkInDate, Date checkOutDate, Collection<IRoom> availableRooms) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.availableRooms = availableRooms;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Collection<IRoom> getAvailableRooms() {
        return availableRooms;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setAvailableRooms(Collection<IRoom> availableRooms) {
        this.availableRooms = availableRooms;
    }

    @Override
    public String toString() {
        return "AvailableRoomsCondition{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", availableRooms=" + availableRooms +
                '}';
    }
}
