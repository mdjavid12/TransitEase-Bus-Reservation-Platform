package com.javid.busReservation.util;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtil {

    public static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use dd-MM-yyyy",e);
        }
    }
}
