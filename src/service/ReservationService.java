package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    private static ReservationService reservationService;

    // key: Customer.email, value: Reservation
    private Map<String, Collection<Reservation>> emailReservationsMap;
    // key: roomId???, value: IRoom
    private Map<String, IRoom> roomIdIRoomMap;

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(IRoom room) {
//        roomIdIRoomMap.put(roomId???, room);
    }

    public IRoom getARoom(String roomId) {
        return roomIdIRoomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        Collection<Reservation> resultReservations = new HashSet<>();

        Collection<Reservation> existingReservations = getCustomerReservation(customer);
        if (existingReservations != null) {
            existingReservations.add(newReservation);
            resultReservations = existingReservations;
        } else {
            resultReservations.add(newReservation);
        }
        emailReservationsMap.put(customer.email, resultReservations);

        return newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;
    }

    private Collection<Reservation> getCustomerReservation(Customer customer) {
        return emailReservationsMap.get(customer.email);
    }

    public void printAllReservation() {}

}
