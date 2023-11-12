package Rooms;

import Booking.BookingInfo;
import Booking.User;

import javax.swing.*;
import java.util.ArrayList;

public class Sheet {
    String name;
    ArrayList<BookingInfo> bookingInfo = new ArrayList<>();

    Sheet(String name)
    {
        this.name = name;
    }

    public void addBooking(User user, int year, int month, int day, int startHour, int endHour)
    {
        bookingInfo.add(new BookingInfo(user, year, month, day, startHour, endHour));
    }

    public boolean IsBooking()
    {
        return !bookingInfo.isEmpty();
    }

    public void print()
    {
        if(bookingInfo.isEmpty())
        {
            System.out.format("(%s) - 예약자가 없습니다.\n", name);
        }else {
            System.out.format("(%s) - 예약자가 %d명 있습니다..\n", name, bookingInfo.size());
            for(var booking : bookingInfo)
                booking.print();
        }
    }

    public boolean matches(String kwd)
    {
        if(name.equals(kwd))
            return true;

        for(var booking : bookingInfo)
        {
            if(booking.matches(kwd))
                return true;
        }
        return false;
    }
}
