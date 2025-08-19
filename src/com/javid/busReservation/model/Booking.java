package com.javid.busReservation.model;
import com.javid.busReservation.dao.*;
import com.javid.busReservation.util.DateUtil;
import java.util.*;
import java.sql.SQLException;

public class Booking {
    public String passengerName;
    public int busNo;
    public  Date date;

    public Booking(String passengerName, int busNo, String dateStr) {
        this.passengerName = passengerName;
        this.busNo = busNo;
        this.date= DateUtil.parseDate(dateStr);
    }

    public boolean isAvailable() throws SQLException{
        BusDAO busdao = new BusDAO();
        int capacity = busdao.getCapacity(busNo);

        BookingDAO bookingdao=new BookingDAO();
        int booked = bookingdao.getBookedCount(busNo,date);

        return booked < capacity;  //return booked<capacity?true:false;
    }
}


