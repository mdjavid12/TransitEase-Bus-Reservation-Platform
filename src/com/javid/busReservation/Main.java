package com.javid.busReservation;
import com.javid.busReservation.model.Booking;
import com.javid.busReservation.service.BookingService;
import com.javid.busReservation.dao.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        BusDAO busdao=new BusDAO();
        busdao.displayBusInfo();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter bus number:");
        int busNo = input.nextInt();

        System.out.print("Enter date (dd-MM-yyyy):");
        String dateStr = input.next();

        System.out.print("Enter passenger name:");
        String name = input.next();
        System.out.println();

        BookingService bookingService = new BookingService();

        System.out.println(bookingService.hasAvailableSeats(busNo,dateStr)+" seats available");
        System.out.println("⏳ Don’t wait! Grab your bus before someone grabs your seat\n");

        int useropt;
        do {
            System.out.println("Enter 1 to book or 2 to exit:");
            useropt = input.nextInt();

            if (useropt == 1) {
                //Create booking
                Booking booking = new Booking(name, busNo, dateStr);
                if (bookingService.bookSeat(booking)) {
                    System.out.println("Booking confirmed!");
                } else {
                    System.out.println("Booking failed. No seats available.");
                }
            }
        } while (useropt == 1);

        input.close();
    }
}


