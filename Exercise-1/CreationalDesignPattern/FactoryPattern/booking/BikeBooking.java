package booking;
public class BikeBooking implements BookingMethod {
    @Override
    public void bookRide(String details) {
        System.out.println("Bike booked successfully with details: " + details);
    }
}
