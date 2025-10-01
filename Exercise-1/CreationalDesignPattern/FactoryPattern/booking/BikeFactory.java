package booking;
public class BikeFactory extends BookingFactory {
    @Override
    public BookingMethod createBookingMethod() {
        return new BikeBooking();
    }
}
