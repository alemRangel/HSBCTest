import com.google.gson.Gson;
import com.hsbc.test.Dto.BookingsResponse;
import com.hsbc.test.models.Booking;
import com.hsbc.test.services.BookingsService;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;


public class BookingTest {
    public BookingsService bookingsService = new BookingsService();
    public Gson jsonConverter = new Gson();

    /**
     * Normally, I would test using something like Mockito, for this purpose I am gonna test that
     * the service does what it is intended to do.
     *
     * This test validates that both services methods work. That we are getting a list of bookings,
     * and that adding a booking actually works. This is not intended to be a real Test, since we
     * would be modifying the database, it is only for principle purpose.
     */
    @Test
    public void TestAddBooking(){
        BookingsResponse bookingsResponse = jsonConverter.fromJson(bookingsService.getAllBookings(), BookingsResponse.class);
        assertNotNull(bookingsResponse);
        assertNotEquals(bookingsResponse.getResponse().size(), 0);
        bookingsService.createBooking("Test", "2", "10/12/2025 21:00");
        BookingsResponse newBookingsResponse = jsonConverter.fromJson(bookingsService.getAllBookings(), BookingsResponse.class);
        assertNotEquals(newBookingsResponse.getResponse().size(), bookingsResponse.getResponse().size());
    }
}
