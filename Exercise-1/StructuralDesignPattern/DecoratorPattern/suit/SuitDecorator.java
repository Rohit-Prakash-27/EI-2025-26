package suit;

public abstract class SuitDecorator implements Suit {
    protected Suit decoratedSuit;

    public SuitDecorator(Suit suit) {
        this.decoratedSuit = suit;
    }

    @Override
    public String getDescription() {
        return decoratedSuit.getDescription();
    }

    @Override
    public boolean hasFeature(String feature) {
        return decoratedSuit.hasFeature(feature);
    }
}
