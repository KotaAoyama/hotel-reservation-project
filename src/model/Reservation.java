package model;

import java.util.Date;
import java.util.regex.Pattern;

public class Reservation {

    public Customer customer;
    public IRoom room;
    public Date checkInDate;
    public Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

//    public Reservation(Date checkInDate, Date checkOutDate) {
//        validateDateFormat(checkInDate, checkOutDate);
//        this.checkInDate = checkInDate;
//        this.checkOutDate = checkOutDate;
//    }
//
//    private void validateDateFormat(Date checkInDate, Date checkOutDate) {
//        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
//        Pattern pattern = Pattern.compile(dateRegex);
//        if (!pattern.matcher((CharSequence) checkInDate).matches()) {
//            throw new IllegalArgumentException("checkInDate is invalid format.");
//        }
//        if (!pattern.matcher((CharSequence) checkOutDate).matches()) {
//            throw new IllegalArgumentException("checkOutDate is invlid format.");
//        }
//    }

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
