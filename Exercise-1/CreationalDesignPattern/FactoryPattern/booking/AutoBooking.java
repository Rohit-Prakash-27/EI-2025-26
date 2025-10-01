package booking;
public class AutoBooking implements BookingMethod {
    @Override
    public void bookRide(String details) {
        System.out.println("Auto booked successfully with details: " + details);
    }
}
