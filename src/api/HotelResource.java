package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    public static Customer getCustomer(String email) {
        return null;
    };

    public static void createACustomer(String email, String firstName, String lastName) {
    }

    public static IRoom getRoom(String roomNumber) {
        return null;
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        return null;
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        return null;
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }
}
