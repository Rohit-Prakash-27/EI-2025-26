package ecommerce;

public class User implements Observer {
    private String username;
    private double desiredPrice;

    public User(String username, double desiredPrice) {
        this.username = username;
        this.desiredPrice = desiredPrice;
    }

    @Override
    public void update(String productName, double oldPrice, double newPrice) {
        if (newPrice <= desiredPrice) {
            System.out.println( username + "!, " + productName +
                    " dropped from " + oldPrice + " to " + newPrice +
                    " (below your desired price " + desiredPrice + ")");
        }
    }
}

