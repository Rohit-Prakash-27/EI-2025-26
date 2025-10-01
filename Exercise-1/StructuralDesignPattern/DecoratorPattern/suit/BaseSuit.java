package suit;

public class BaseSuit implements Suit {
    @Override
    public String getDescription() {
        return "Basic IronMan Suit";
    }

    @Override
    public boolean hasFeature(String feature) {
        return false; // base suit has no extra features
    }
}
