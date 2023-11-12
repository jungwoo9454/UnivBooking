package Booking;
import java.util.Date;

public class BookingInfo {
    User user;

    Date date;
    int startHour;
    int endHour;
    public BookingInfo(User user, int year, int month, int day, int startHour, int endHour)
    {
        date = new Date();
        this.user = user;
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public void print()
    {
        System.out.format("\t예약 시간 : %d년 %d월 %d일 %d시~%d시(예약자 : %s(%s))\n",
                date.getYear(), date.getMonth(), date.getDay(), startHour, endHour, user.name, user.code);
    }

    public boolean dateEquals(BookingInfo info)
    {
        boolean date_equal = !info.date.equals(date);
        boolean time_equal = endHour <= info.startHour || startHour >= info.endHour;

        return date_equal && time_equal;
    }

    public boolean matches(String kwd)
    {
        if(user.name.contains(kwd))
            return true;
        else if(user.code.contains(kwd))
            return true;
        return false;
    }
}
