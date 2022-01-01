package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;
import java.util.stream.Collectors;

public class ReservationService {

    private static ReservationService reservationService;
    private final Set<Reservation> reservationSet = new HashSet<>();
    private final Map<String, IRoom> roomMap = new HashMap<>();

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(IRoom room) {
        IRoom addedRoom = roomMap.put(room.getRoomNumber(), room);
        if (addedRoom != null) {
            System.out.println("Successfully added room!");
        }
    }

    public IRoom getARoom(String roomId) {
        if (roomId == null) {
            System.out.println("Internal Error occurred!");
            throw new IllegalArgumentException("Provided roomNumber is null.");
        }

        return roomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        boolean isAdded = reservationSet.add(newReservation);
        if (isAdded) {
            System.out.println("Successfully booked the room!");
        }
        return newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        try {
            Collection<IRoom> alreadyReservedRooms = reservationSet.stream()
                    .filter(reservation ->
                            checkInDate.compareTo(reservation.checkInDate) >= 0 &&
                                    checkInDate.compareTo(reservation.checkOutDate) < 0)
                    .filter(reservation ->
                            checkOutDate.compareTo(reservation.checkInDate) > 0 &&
                                    checkOutDate.compareTo(reservation.checkOutDate) <= 0)
                    .map(reservation -> reservation.room)
                    .collect(Collectors.toSet());

            return getAvailableRooms(alreadyReservedRooms);

        } catch (NullPointerException ex) {
            System.out.println("Internal Server Error occurred!");
            return new HashSet<IRoom>();
        }
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        if (customer == null) {
            return null;
        }

        return reservationSet.stream()
                .filter(reservation -> Objects.equals(
                        reservation.customer != null
                        ? reservation.customer.email
                        : null,
                        customer.email))
                .collect(Collectors.toSet());
    }

    public void printAllReservation() {
        for (Reservation reservation : reservationSet) {
            System.out.println(reservation);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return roomMap.values();
    }

    private Collection<IRoom> getAvailableRooms(Collection<IRoom> alreadyReservedRooms) {

        return roomMap.values().stream()
                .filter(room -> !alreadyReservedRooms.contains(room))
                .collect(Collectors.toSet());
    }
}
