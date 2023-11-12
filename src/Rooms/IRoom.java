package Rooms;

import Booking.BookingInfo;
import Booking.User;

import java.util.ArrayList;
import java.util.Scanner;

public interface IRoom {

    boolean matches(String kwd);
    boolean bookingMatches(String kwd);
    void print();
    void bookingPrint();
    void sheetbookingPrint(String sheetname);
    void read(Scanner scanner);
    boolean IsBooking(Sheet sheet, User user, int year, int month, int day, int startHour, int endHour);

    Sheet getSheet(String name);
    boolean IsNotSheet();
}
