package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class ReservationService {

    Map<String, Reservation> reservationMap;

    public static void addRoom(IRoom room) {}

    public static IRoom getARoom(String roomId) {
        return null;
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        return null;
    }

    public static void printAllReservation() {}

}
