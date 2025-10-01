import java.util.Scanner;
import ecommerce.*;
public class PriceDropApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = sc.nextLine();
        System.out.print("Enter initial price: ");
        double initialPrice = sc.nextDouble();
        Product product = new Product(productName, initialPrice);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter username: ");
            String name = sc.nextLine();
            System.out.print("Enter desired price: ");
            double desiredPrice = sc.nextDouble();
            sc.nextLine();
            product.registerObserver(new User(name, desiredPrice));
        }

        String choice;
        do {
            System.out.print("\nEnter new price (or 'q' to quit): ");
            choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("q")) {
                try {
                    double price = Double.parseDouble(choice);
                    product.setPrice(price);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number, try again.");
                }
            }
        } while (!choice.equalsIgnoreCase("q"));

        sc.close();
    }
}
