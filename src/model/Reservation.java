package model;

import java.util.Date;

public class Reservation {

    public Customer customer;
    public IRoom room;
    public Date checkInDate;
    public Date checkOutDate;



    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
