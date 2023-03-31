package com.hsbc.test.mocks;

import com.hsbc.test.models.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BookingsMocks {
    //This class is for creating Mock Objects to test the API.

    public List<Booking> allBookings = new ArrayList<>();
    public BookingsMocks(){
        allBookings.add(new Booking(UUID.randomUUID(), "Alejandro Rangel", 2, new Date()));
        allBookings.add(new Booking(UUID.randomUUID(), "David Rangel", 2, new Date()));
        allBookings.add(new Booking(UUID.randomUUID(), "Alejandro Rangel Jr", 4, new Date()));
        allBookings.add(new Booking(UUID.randomUUID(), "Customer 1", 5, new Date()));
        allBookings.add(new Booking(UUID.randomUUID(), "Messi", 2, new Date()));
        allBookings.add(new Booking(UUID.randomUUID(), "Cr7", 2, new Date()));
    }
}
