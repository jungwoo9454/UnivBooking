package Rooms;

import Booking.User;

import java.util.Scanner;

public interface IRoom {

    void matches(String kwd);
    void print();
    void read(Scanner scanner);
    //void roomBooking(User user, )
}
