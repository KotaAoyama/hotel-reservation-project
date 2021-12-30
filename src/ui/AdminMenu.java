package ui;

import java.util.Scanner;

public class AdminMenu {

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

                } else if (userInput == 2) {

                } else if (userInput == 3) {

                } else if (userInput == 4) {

                } else if (userInput == 5) {
                    keepRunning = false;
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.displayMainMenu();
                } else {
                    System.out.println("Input is invalid. Please input number, from 1 to 5.");
                }
            }

        } catch (Exception ex) {
            ex.getLocalizedMessage();
        }
    }
}
