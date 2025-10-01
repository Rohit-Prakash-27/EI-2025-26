package src;

import java.util.Scanner;

public class Shop {
    private TShirt tshirt; 
    private TShirtPrototype prototype; 
    private Scanner scanner;

    public Shop(TShirtPrototype prototype) {
        this.prototype = prototype;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Welcome to TShirt Shop ===");
        System.out.println("1. Create New TShirt");
        System.out.println("2. Edit TShirt");
        System.out.println("3. Display TShirt");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                createNewTShirt();
                start();
                break;
            case "2":
                editTShirt();
                start();
                break;
            case "3":
                displayTShirt();
                start();
                break;
            case "4":
                System.out.println("Exiting Shop.");
                scanner.close();
                break;
            default:
                System.out.println("Invalid choice!");
                start();
                break;
        }
    }

    private void createNewTShirt() {
        tshirt = new TShirt(prototype.clone());
        System.out.println("New TShirt created from prototype.");
    }

    private void editTShirt() {
        if (tshirt == null) {
            System.out.println("No TShirt to edit. Create one first.");
            return;
        }

        System.out.println("Edit TShirt:");
        System.out.println("1. Change Color");
        System.out.println("2. Change Size");
        System.out.println("3. Change Price");
        System.out.println("4. Back");

        System.out.print("Enter choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Enter new color: ");
                tshirt.setColor(scanner.nextLine());
                break;
            case "2":
                System.out.print("Enter new size: ");
                tshirt.setSize(scanner.nextLine());
                break;
            case "3":
                System.out.print("Enter new price: ");
                tshirt.setPrice(Double.parseDouble(scanner.nextLine()));
                break;
            case "4":
                return;
            default:
                System.out.println("Invalid choice.");
        }
        editTShirt(); // allow further edits
    }

    private void displayTShirt() {
        if (tshirt == null) {
            System.out.println("No TShirt to display. Create one first.");
            return;
        }
        tshirt.display();
    }
}
