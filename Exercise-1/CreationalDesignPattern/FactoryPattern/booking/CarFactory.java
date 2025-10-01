package booking;
public class CarFactory extends BookingFactory {
    @Override
    public BookingMethod createBookingMethod() {
        return new CarBooking();
    }
}
