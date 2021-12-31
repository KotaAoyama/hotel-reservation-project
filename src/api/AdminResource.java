package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    private final CustomerService customerService = CustomerService.getInstance();

    private static AdminResource adminResource;

    public static AdminResource getInstance() {
        if (adminResource == null) {
            adminResource = new AdminResource();
        }
        return adminResource;
    }

    public Customer getCustomer(String email) {
        return null;
    }

    public void addRoom(List<IRoom> rooms) {}

    public Collection<IRoom> getAllRooms() {
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {}
}
