package booking;
import java.util.Scanner;

public class BookingProcessor {
    private Scanner scanner;

    public BookingProcessor() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Select booking option:");
        System.out.println("1. Car");
        System.out.println("2. Auto");
        System.out.println("3. Bike");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                processBooking(new CarFactory());
                break;
            case "2":
                processBooking(new AutoFactory());
                break;
            case "3":
                processBooking(new BikeFactory());
                break;
            case "4":
                System.out.println("Exiting booking system.");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                start(); // back to main menu
                break;
        }
    }

    private void processBooking(BookingFactory factory) {
        BookingMethod method = factory.createBookingMethod();
        System.out.print("Enter booking details (e.g. Pickup-Drop Location): ");
        String details = scanner.nextLine();
        method.bookRide(details);
        start(); // return to menu
    }
}
