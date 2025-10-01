package src;

public class TShirtPrototype {
    private String name;
    private String color;
    private String size;
    private double price;

    public TShirtPrototype(String name, String color, String size, double price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public TShirtPrototype clone() {
        return new TShirtPrototype(name, color, size, price);
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getSize() {
        return size;
    }
    public double getPrice() {
        return price;
    }
}
