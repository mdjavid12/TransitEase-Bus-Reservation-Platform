package com.javid.busReservation.model;
import com.javid.busReservation.dao.*;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {

    public String passengerName;
    public int busNo;
    public  Date date;



    public Booking(String passengerName, int busNo, String dateStr) {
        this.passengerName = passengerName;
        this.busNo = busNo;

        setDate(dateStr);

    }

    public  void setDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use dd-MM-yyyy");
        }
    }

    public boolean isAvailable() throws SQLException{

        BusDAO busdao = new BusDAO();
        int capacity = busdao.getCapacity(busNo);

        BookingDAO bookingdao=new BookingDAO();
        int booked = bookingdao.getBookedCount(busNo,date);

        return booked < capacity;  //return booked<capacity?true:false;
    }

}


