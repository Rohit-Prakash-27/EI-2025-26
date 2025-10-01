package src;
public class TShirt {
    private String name;
    private String color;
    private String size;
    private double price;

    public TShirt(TShirtPrototype prototype) {
        this.name = prototype.getName();
        this.color = prototype.getColor();
        this.size = prototype.getSize();
        this.price = prototype.getPrice();
    }

    public void display() {
        System.out.println("=== TShirt Details ===");
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Size: " + size);
        System.out.println("Price: " + price);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
