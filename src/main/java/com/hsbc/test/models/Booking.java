package com.hsbc.test.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter
public class Booking {
    private UUID id;
    private String customerName;
    private int tableSize;
    private Date reservationsDateTime;

    public Booking(){

    }

    public Booking(UUID id, String customerName, int tableSize, Date reservationsDateTime) {
        this.id = id;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.reservationsDateTime = reservationsDateTime;
    }
}
