import src.*;

public class Main {
    public static void main(String[] args) {
        // Pre-defined TShirt prototype
        TShirtPrototype tshirtPrototype = new TShirtPrototype("Basic Tee", "White", "M", 250);

        // Start shop
        Shop shop = new Shop(tshirtPrototype);
        shop.start();
    }
}
