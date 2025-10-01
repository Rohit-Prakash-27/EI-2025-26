import suit.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Suit suit = new BaseSuit();

        System.out.println("Current Suit: " + suit.getDescription()); // initial suit

        while (true) {
            System.out.println("\n--- IronMan Suit Builder ---");
            System.out.println("1. Add FlightJet");
            System.out.println("2. Add Nanotech");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = sc.nextInt();

                if (choice < 0) {
                    System.out.println("Negative numbers are not allowed. Try again.");
                    continue;
                }

                boolean addedFeature = false;

                switch (choice) {
                    case 1 -> {
                        if (suit.hasFeature("FlightJet")) {
                            System.out.println("FlightJet already added!");
                        } else {
                            suit = new FlightJet(suit);
                            addedFeature = true;
                        }
                    }
                    case 2 -> {
                        if (suit.hasFeature("Nanotech")) {
                            System.out.println("Nanotech already added!");
                        } else {
                            suit = new Nanotech(suit);
                            addedFeature = true;
                        }
                    }
                    case 0 -> {
                        System.out.println("Exiting... Jarvis signing off.");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please select from the menu.");
                }

                // show updated suit if feature was added
                if (addedFeature) {
                    System.out.println("Upgraded Suit: " + suit.getDescription());
                }

                // check for full upgrade
                if (suit.hasFeature("FlightJet") && suit.hasFeature("Nanotech")) {
                    System.out.println("Suit is fully upgraded!");
                    System.out.println("Exiting... Jarvis signing off.");
                    sc.close();
                    return;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
