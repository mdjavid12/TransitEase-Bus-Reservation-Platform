package com.javid.busReservation.service;

import com.javid.busReservation.dao.*;
import com.javid.busReservation.model.Booking;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.sql.SQLException;


public class BookingService {

    private final BookingDAO bookingDAO= new BookingDAO();
    private final BusDAO busDAO = new BusDAO();


    public boolean bookSeat(Booking booking) throws SQLException {
        // 1. Validate seat availability
        if (!booking.isAvailable()) {
            return false;
        }
        bookingDAO.addBooking(booking);
        return true;
    }


    public int hasAvailableSeats(int busNo, String dateStr) throws SQLException, ParseException {
        int capacity = busDAO.getCapacity(busNo);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date utilDate = sdf.parse(dateStr);
        int booked = bookingDAO.getBookedCount(busNo, utilDate);
        return capacity-booked;
    }
}


