package suit;

public class FlightJet extends SuitDecorator {
    public FlightJet(Suit suit) {
        super(suit);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + FlightJet";
    }

    @Override
    public boolean hasFeature(String feature) {
        if (feature.equals("FlightJet")) return true;
        return super.hasFeature(feature);
    }
}
