package com.javid.busReservation.service;
import com.javid.busReservation.dao.*;
import com.javid.busReservation.model.Booking;
import com.javid.busReservation.util.DateUtil;
import java.util.Date;
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


    public int hasAvailableSeats(int busNo, String dateStr) throws SQLException {
        int capacity = busDAO.getCapacity(busNo);
        Date date= DateUtil.parseDate(dateStr);
        int booked = bookingDAO.getBookedCount(busNo, date);
        return capacity-booked;
    }
}


