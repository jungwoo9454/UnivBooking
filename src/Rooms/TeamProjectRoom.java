package Rooms;

import Booking.BookingInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamProjectRoom implements IRoom {
    String code;
    String name;
    BookingInfo bookingInfo;
    int count;
    @Override
    public void matches(String kwd) {

    }

    @Override
    public void print() {
        System.out.format("%s %s %s", code, name, count);
    }

    @Override
    public void read(Scanner scanner) {
        code = scanner.next();
        name = scanner.next();
        count = scanner.nextInt();

    }
}
