package ecommerce;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(double oldPrice, double newPrice);
}

