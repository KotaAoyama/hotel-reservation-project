package ui;

import api.AdminResource;
import api.HotelResource;
import model.*;

import java.util.ArrayList;
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

                switch (userInput) {
                    case 1:
                        Collection<Customer> customers = adminResource.getAllCustomers();
                        for (Customer customer : customers) {
                            System.out.println(customer);
                        }
                        break;
                    case 2:
                        Collection<IRoom> rooms = adminResource.getAllRooms();
                        for (IRoom room : rooms) {
                            System.out.println(room);
                        }
                        break;
                    case 3:
                        adminResource.displayAllReservations();
                        break;
                    case 4:
                        List<IRoom> newRooms = createRooms(scanner);
                        adminResource.addRoom(newRooms);
                        break;
                    case 5:
                        keepRunning = false;
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.displayMainMenu();
                        break;
                    default:
                        System.out.println("Input is invalid. Please input number, from 1 to 5.");
                        break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex); // for debug
            ex.getLocalizedMessage();
        }
    }

    private List<IRoom> createRooms(Scanner scanner) {
        List<IRoom> newRoomList = new ArrayList<>();
        String userInput;

        boolean keepRunning = true;
        while (keepRunning) {
            IRoom newRoom = createARoom(scanner);
            newRoomList.add(newRoom);

            System.out.println("Do you continue adding another room?");
            System.out.println("Please type, 'yes' or 'no'.");
            userInput = scanner.nextLine();
            if (!userInput.equals("yes")) {
                keepRunning = false;
                System.out.println("Thank you for adding rooms");
            }
        }

        return newRoomList;
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
