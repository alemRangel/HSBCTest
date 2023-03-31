package com.hsbc.test.services;

import com.google.gson.Gson;
import com.hsbc.test.Dto.BaseResponse;
import com.hsbc.test.Dto.BookingsResponse;
import com.hsbc.test.Repository.BookingsRepository;
import com.hsbc.test.models.Booking;
import com.hsbc.test.util.UtilClass;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BookingsService {
    //Simulation of Singleton for the repository.
    BookingsRepository repository = new BookingsRepository();
    Gson gson = new Gson();
    UtilClass util = new UtilClass();
    StringUtils stringUtils = new StringUtils();
    /**
     * We handle the request given by the controller and add some simple validations
     * I am assuming:
     * We can ALWAYS add a new booking at any requested hour.
     * Name and number of people are required parameters.
     */
    public String createBooking(String name, String tableSize, String dateToBookStr){
        BaseResponse response = validateValues(name, tableSize, dateToBookStr);
        if (response.getCode() != 400) {
            try {
                Date dateToBook = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dateToBookStr);
                if (dateToBook.before(new Date())) {
                    response.setCode(400);
                    response.setMessage("You cannot add a booking before this moment.");
                } else {
                    repository.createBookingRepository(new Booking(UUID.randomUUID(), name, Integer.parseInt(tableSize), dateToBook));
                    response.setCode(201);
                    response.setMessage("Booking added successfully.");
                }
            } catch (ParseException exception) {
                response.setCode(400);
                response.setMessage("Date provided in wrong format, dd/MM/yyyy hh:mm required.");
            } catch (Exception exception) {
                response.setCode(500);
                response.setMessage("Unknown Error.");
            }
        }
        return gson.toJson(response);
    }

    /**
     * For the purpose of this test, I am assuming the next:
     * I am always returning the full list of current bookings, only parsing it to JSON.
     * @return List of all bookings of the restaurant.
     */
    public String getAllBookings() {
        BookingsResponse response = new BookingsResponse();
        response.setResponse(repository.getAllBookingsRepository());
        response.setCode(response.getResponse().isEmpty() ? 204 : 200);
        response.setMessage("Completed correctly.");
        return gson.toJson(response);
    }

    private BaseResponse validateValues(String name, String tableSize, String dateToBookStr){
        BaseResponse response = new BaseResponse();
        if(util.isStringNullOrEmpty(name)){
            response.setCode(400);
            response.setMessage("Name is required");
        }
        else if(util.isStringNullOrEmpty(tableSize)){
            response.setCode(400);
            response.setMessage("TableSize is required");
        } else if(!stringUtils.isNumeric(tableSize)){
            response.setCode(400);
            response.setMessage("TableSize must be a positive Integer");
        } else if(util.isStringNullOrEmpty(dateToBookStr)){
            response.setCode(400);
            response.setMessage("DateToBook is required.");
        }
        return response;
    }
}
