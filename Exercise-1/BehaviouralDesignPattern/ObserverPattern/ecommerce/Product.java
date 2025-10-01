package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private String name;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double newPrice) {
        if (newPrice < price) {
            double oldPrice = price;
            price = newPrice;
            notifyObservers(oldPrice, newPrice);
        } else {
            price = newPrice;
            System.out.println("Price updated to " + newPrice + " (no notification)");
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(double oldPrice, double newPrice) {
        for (Observer observer : observers) {
            observer.update(name, oldPrice, newPrice);
        }
    }
}
