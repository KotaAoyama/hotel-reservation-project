package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.awt.List;
import java.util.*;
import java.util.stream.Collectors;

public class ReservationService {

    private static ReservationService reservationService;
    private final Set<Reservation> reservationSet = new HashSet<>();
    private final Map<String, IRoom> roomMap = new HashMap<>();
    private int autoIncrementRoomId = 1;

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(IRoom room) {
        roomMap.put(String.valueOf(autoIncrementRoomId), room);
        autoIncrementRoomId++;
    }

    public IRoom getARoom(String roomId) {
        return roomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return null;
    }

    public void printAllReservation() {}

    public Collection<IRoom> getAllRooms() {
        return roomMap.values();
    }

}
