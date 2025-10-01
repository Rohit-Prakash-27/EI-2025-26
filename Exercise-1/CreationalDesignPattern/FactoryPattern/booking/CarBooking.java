package booking;
public class CarBooking implements BookingMethod {
    @Override
    public void bookRide(String details) {
        System.out.println("Car booked successfully with details: " + details);
    }
}
