package booking;
public class AutoFactory extends BookingFactory {
    @Override
    public BookingMethod createBookingMethod() {
        return new AutoBooking();
    }
}
