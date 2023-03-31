package com.hsbc.test;

import com.hsbc.test.services.BookingsService;
import com.hsbc.test.util.UtilClass;
import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;


public class MainController {
    public static void main(String[] args){
        BookingsService bookingsService = new BookingsService();
        UtilClass util = new UtilClass();
        MuServer server = MuServerBuilder.httpServer()
                .addHandler(Method.GET, "/", (request, response, pathParams) -> {
                    String instructions = "API instructions:" +
                            "GET /bookings/getAll to see all reservations. ";
                    response.write(instructions);
                })
                .addHandler(Method.POST, "/bookings/newBooking", (((request, response, pathParams) -> {
                    response.write(bookingsService.createBooking(
                            request.form().get("name"),
                            request.form().get("numberOfPersons"),
                            request.form().get("dateToBook")));
                })))
                .addHandler(Method.GET, "/bookings/getAll", ((request, response, pathParams) -> {
                    response.write(bookingsService.getAllBookings());
                }))
                .start();

        System.out.println("Started server at " + server.uri());
    }
}
