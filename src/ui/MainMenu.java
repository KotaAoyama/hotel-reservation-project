package ui;

import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.sql.Date;
import java.util.*;

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
                        // search reserved rooms and show available rooms
//                        Customer myCustomer = checkAccount(scanner);
                        Collection<IRoom> availableRooms = getAvailableRooms(scanner);
                        IRoom selectedRoom = getAvailableRoom(scanner, availableRooms);

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

    private Customer checkAccount(Scanner scanner) {

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("");


            keepRunning = false;
        }

        return null;
    }

    private IRoom getAvailableRoom(Scanner scanner, Collection<IRoom> availableRooms) {
        IRoom selectedRoom = null;

        boolean keepRunning = true;
        while(keepRunning) {
            System.out.println("Select a roomNumber.");
            for (IRoom availableRoom : availableRooms) {
                System.out.println(availableRoom);
            }

            String selectedRoomNumber = scanner.nextLine();
            long count = availableRooms.stream()
                    .filter(room -> Objects.equals(room.getRoomNumber(), selectedRoomNumber))
                    .count();
            if (count != 1.0) {
                System.out.println("Selected roomNumber is invalid. Select a roomNumber again.");
                continue;
            }

            selectedRoom  = hotelResource.getRoom(selectedRoomNumber);
            if (selectedRoom == null) {
                System.out.println("Internal Error occurred!");
                throw new IllegalArgumentException("selectedRoomNumber is invalid.");
            }

            keepRunning = false;
        }

        return selectedRoom;
    }

    private Collection<IRoom> getAvailableRooms(Scanner scanner) {
        Date checkInDate;
        Date checkOutDate;
        Collection<IRoom> availableRooms = new HashSet<>();

        boolean keepRunning = true;
        while (keepRunning) {
            int compared;
            try {
                System.out.println("Please input checkInDate such as 2022-01-01");
                checkInDate = Date.valueOf(scanner.nextLine());
                System.out.println("Please input checkOutDate such as 2022-01-02.");
                checkOutDate = Date.valueOf(scanner.nextLine());
                compared = checkInDate.compareTo(checkOutDate);
            } catch (IllegalArgumentException ex) {
                System.out.println("Date format is invalid.");
                continue;
            }
            if (compared >= 0) {
                System.out.println("checkOutDate must be after checkInDate.");
                continue;
            }

            availableRooms = hotelResource.findARoom(checkInDate, checkOutDate);

            keepRunning = false;
        }

        
        return availableRooms;
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
