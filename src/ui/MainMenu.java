package ui;

import java.util.Scanner;

public class MainMenu {


    public void displayMainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {

            boolean keepRunning = true;
            while(keepRunning) {
                System.out.println("==================================");
                System.out.println("◇◆◇◆◇ Hotel Reservation Menu ◇◆◇◆◇");
                System.out.println("==================================");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("==================================");
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput == 1) {

                } else if (userInput == 2) {

                } else if (userInput == 3) {

                } else if (userInput == 4) {
                    keepRunning = false;
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.displayAdminMenu();
                } else if (userInput == 5) {
                    keepRunning = false;
                    System.out.println("Exit!");
                } else {
                    System.out.println("Input is invalid. Please input number, from 1 to 5.");
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Input is invalid. Please input number, from 1 to 5.");
        } catch (Exception ex) {
            ex.getLocalizedMessage();
        }
    }

}
