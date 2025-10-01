package suit;

public class Nanotech extends SuitDecorator {
    public Nanotech(Suit suit) {
        super(suit);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Nanotech";
    }

    @Override
    public boolean hasFeature(String feature) {
        if (feature.equals("Nanotech")) return true;
        return super.hasFeature(feature);
    }
}
