package ui;

import api.HotelResource;
import model.Customer;

import java.util.Scanner;

public class MainMenu {

    private final HotelResource hotelResource = HotelResource.getInstance();

    public void displayMainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {

            boolean keepRunning = true;
            while (keepRunning) {
                System.out.println("==================================");
                System.out.println("◇◆◇◆◇ Hotel Reservation Menu ◇◆◇◆◇");
                System.out.println("==================================");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("==================================");

                int userInput;
                try {
                    userInput = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Input is invalid. Select a number, from 1 to 5.");
                    continue;
                }

                switch (userInput) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        Customer newCustomer = createCustomer(scanner);
                        hotelResource.createACustomer(newCustomer.email, newCustomer.firstName, newCustomer.lastName);
                        break;
                    case 4:
                        keepRunning = false;
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.displayAdminMenu();
                        break;
                    case 5:
                        keepRunning = false;
                        System.out.println("Exit!");
                        break;
                    default:
                        System.out.println("Input is invalid. Select a number, from 1 to 5.");
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex); // For Debug
            ex.getLocalizedMessage();
        }
    }

    private Customer createCustomer(Scanner scanner) {
        Customer newCustomer = null;
        String email;
        String firstName;
        String lastName;

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Please input your email.");
            email = scanner.nextLine();
            System.out.println("Please input your first name.");
            firstName = scanner.nextLine();
            System.out.println("Please input your last name.");
            lastName = scanner.nextLine();

            try {
                newCustomer = new Customer(firstName, lastName, email);
                System.out.println("Thank you!");
                keepRunning = false;
            } catch (IllegalArgumentException ex) {
                System.out.println("Email format is invalid.");
            }
        }

        return newCustomer;
    }

}
