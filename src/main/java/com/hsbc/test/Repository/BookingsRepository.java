package com.hsbc.test.Repository;

import com.hsbc.test.models.Booking;
import com.hsbc.test.mocks.BookingsMocks;

import java.util.List;

public class BookingsRepository {
    //We simulate a datasource by using the Mocks class.
    private BookingsMocks bookingsMocks = new BookingsMocks();

    /**
     * We add the requested booking to the list of bookings.
     * @param bookingDto
     */
    public void createBookingRepository(Booking bookingDto){
        this.bookingsMocks.allBookings.add(bookingDto);
    }

    /**
     * For the purpose of this test, we are simulating a request to whatever database we are using and getting al bookings.
     * Ideally, we may add filtering by day, since getting ALL bookings seems unuseful.
     * @return List of all bookings of the restaurant.
     */
    public List<Booking> getAllBookingsRepository(){
        return this.bookingsMocks.allBookings;
    }
}
