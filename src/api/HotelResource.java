package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    private static HotelResource hotelResource;

    public static HotelResource getInstance() {
        if (hotelResource == null) {
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    public Customer getCustomer(String email) {
        return null;
    };

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        return null;
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return null;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }
}
