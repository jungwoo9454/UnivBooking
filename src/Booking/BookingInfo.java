package Booking;
import java.util.Date;

public class BookingInfo {
    User user;

    Date date;
    int startHour;
    int endHour;
    public BookingInfo(User user, int year, int month, int day, int startHour, int endHour)
    {
        this.user = user;
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);
        this.startHour = startHour;
        this.endHour = endHour;
    }

    void print()
    {
        System.out.format("예약 시간 : %d년 %d월 %d일 %d시~%d시(예약자 : %s(%s))",
                date.getYear(), date.getMonth(), date.getDay(), startHour, endHour, user.name, user.code);
    }
}
