package service;

import model.Customer;

import java.util.Collection;
import java.util.Map;

public class CustomerService {

    private static Map<String, Customer> customerMap;

    public static void addCustomer(String email, String firstName, String lastName) {
        customerMap.put(email, new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail) {
        return customerMap.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {
        return customerMap.values();
    }
}
