package api;

import model.AvailableRoomsCondition;
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
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        Customer customer = null;
        try {
            customer = validateCustomer(customerEmail);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }

        return reservationService.reserveARoom(customer, room, checkInDate, CheckOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = null;

        try {
            customer = validateCustomer(customerEmail);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }

        return reservationService.getCustomerReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    private Customer validateCustomer(String customerEmail) {
        if (customerEmail == null) {
            throw new IllegalArgumentException("The email is invalid. Please input again.");
        }

        Customer customer = hotelResource.getCustomer(customerEmail);
        if (customer == null) {
            throw new IllegalArgumentException("The email doesn't exist in our customers. Please create your account first.");
        }

        return customer;
    }

    public AvailableRoomsCondition getRecommendedRoomsCondition(Date checkInDate, Date checkOutDate) {
        return reservationService.getRecommendedRoomsCondition(checkInDate, checkOutDate);
    }
}
