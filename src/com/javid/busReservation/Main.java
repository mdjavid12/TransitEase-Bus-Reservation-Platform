package com.javid.busReservation;
import com.javid.busReservation.dao.BusDAO;
import com.javid.busReservation.model.Booking;

import com.javid.busReservation.dao.BookingDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner javi=new Scanner(System.in);

        BusDAO busdao=new BusDAO();
        busdao.displayBusInfo();

        int useropt;
        do {
            System.out.println("Enter 1 for booking and 2 to exit:");
            useropt = javi.nextInt();

            if (useropt == 1) {
                Booking booking = new Booking();
                if (booking.isAvailable()) {

                    BookingDAO bookingdao= new BookingDAO();
                    bookingdao.addBooking(booking);
                    System.out.println("Your booking is confirmed");
                } else {
                    System.out.println("Sorry! Seats full. Please choose another bus or date.");
                }
            }
        } while (useropt == 1);
        javi.close();
    }
}


