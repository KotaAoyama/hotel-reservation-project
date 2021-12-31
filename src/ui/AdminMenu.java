package ui;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private final AdminResource adminResource = AdminResource.getInstance();
    private final HotelResource hotelResource = HotelResource.getInstance();

    public void displayAdminMenu() {
        try (Scanner scanner = new Scanner(System.in)) {

            boolean keepRunning = true;
            while(keepRunning) {
                System.out.println("==================================");
                System.out.println("◇◆◇◆◇◆◇◆◇   Admin Menu   ◇◆◇◆◇◆◇◆◇");
                System.out.println("==================================");
                System.out.println("1. See all Customers");
                System.out.println("2. See all Rooms");
                System.out.println("3. See all Reservations");
                System.out.println("4. Add a Room");
                System.out.println("5. Back to Main Menu");
                System.out.println("==================================");

                int userInput;
                try {
                    userInput = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Input is invalid. Please input number, from 1 to 5.");
                    continue;
                }

                if (userInput == 1) {
                    // See all Customers
                    Collection<Customer> customers = adminResource.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                } else if (userInput == 2) {
                    // See all Rooms
                    Collection<IRoom> rooms = adminResource.getAllRooms();
                    for (IRoom room : rooms) {
                        System.out.println(room);
                    }
                } else if (userInput == 3) {
                    // See all Reservations

                } else if (userInput == 4) {
                    // Add a room
                    List<IRoom> rooms = (List<IRoom>) adminResource.getAllRooms();
                    IRoom newRoom = createARoom(scanner);
                    rooms.add(newRoom);
                    adminResource.addRoom(rooms);
                } else if (userInput == 5) {
                    // Back to Main Menu
                    keepRunning = false;
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.displayMainMenu();
                } else {
                    System.out.println("Input is invalid. Please input number, from 1 to 5.");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex); // for debug
            ex.getLocalizedMessage();
        }
    }

    private IRoom createARoom(Scanner scanner) {
        String roomNumber;
        double price;
        RoomType enumeration;
        IRoom newRoom = null;

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Please input the roomNumber.");
            roomNumber = scanner.nextLine();

            System.out.println("Please input the price.");
            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("price is invalid format.");
                continue;
            }

            System.out.println("Please select roomType, 1 or 2.");
            System.out.println("1. SINGLE");
            System.out.println("2. DOUBLE");
            int userInput;
            try {
                userInput = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("roomType is invalid format.");
                continue;
            }
            if (userInput == 1) {
                enumeration = RoomType.SINGLE;
            } else if (userInput == 2) {
                enumeration = RoomType.DOUBLE;
            } else {
                System.out.println("roomType is invalid format.");
                continue;
            }

            try {
                newRoom = new Room(roomNumber, price, enumeration);
                System.out.println("Thank you!");
                keepRunning = false;
            } catch (IllegalArgumentException ex) {
                System.out.println("Failed creating the room");
            }
        }

        return newRoom;
    }
}
