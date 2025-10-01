package ecommerce;

public interface Observer {
    void update(String productName, double oldPrice, double newPrice);
}
