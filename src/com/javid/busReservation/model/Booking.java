package com.javid.busReservation.model;

import com.javid.busReservation.dao.BookingDAO;
import com.javid.busReservation.dao.BusDAO;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {

    public String Passengername;
    public int busNo;
    public Date date;


    public Booking() {
        Scanner javi = new Scanner(System.in);
        System.out.println("Enter Passenger Name: ");
        Passengername = javi.next();

        System.out.println("Enter Bus number: ");
        busNo = javi.nextInt();

        System.out.println("Enter the journey date(dd-MM-yyy): ");
        String dateinput = javi.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateinput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
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


