package Rooms;

import Booking.BookingInfo;
import Booking.User;

public class Sheet {
    String name;
    BookingInfo bookingInfo;

    Sheet(String name)
    {
        this.name = name;
        bookingInfo = null;
    }

    public void setBooking(User user, int year, int month, int day, int startHour, int endHour)
    {
        bookingInfo = new BookingInfo(user, year, month, day, startHour, endHour);
    }

    public boolean IsBooking()
    {
        return bookingInfo == null ? false : true;
    }
}
