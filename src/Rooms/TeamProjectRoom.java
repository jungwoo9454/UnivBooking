package Rooms;

import Booking.BookingInfo;
import Booking.User;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamProjectRoom implements IRoom {
    int number;
    String code;
    String name;
    ArrayList<BookingInfo> bookingInfos = new ArrayList<>();
    int count;
    public TeamProjectRoom(int num)
    {
        number = num;
    }
    @Override
    public boolean matches(String kwd) {
        if(code.contains(kwd) || name.contains(kwd))
            return true;
        return false;
    }

    @Override
    public boolean bookingMatches(String kwd) {
        for(var booking : bookingInfos)
        {
            if(booking.matches(kwd))
                booking.print();
        }
        return false;
    }

    @Override
    public void print() {
        System.out.format("%s(%s) 수용인원 : %s명\n", name, code, count);
    }

    @Override
    public void bookingPrint() {

        if(bookingInfos.isEmpty())
        {
            System.out.format("%s(%s)에 예약자가 없습니다.\n", name, code);
        }else {
            System.out.format("%s(%s) 예약자 현황\n", name, code);
            for(var booking : bookingInfos)
                booking.print();
        }
    }

    @Override
    public void sheetbookingPrint(String sheetname) {
        Sheet sheet = getSheet(sheetname);
        sheet.print();
    }

    @Override
    public void read(Scanner scanner) {
        code = scanner.next();
        name = scanner.next();
        count = scanner.nextInt();
    }

    @Override
    public boolean IsBooking(Sheet sheet, User user, int year, int month, int day, int startHour, int endHour) {
        BookingInfo bookingInfo = new BookingInfo(user, year, month, day, startHour, endHour);
        for(var info : bookingInfos)
            if(info.dateEquals(bookingInfo) == false)
                return false;

        bookingInfos.add(bookingInfo);
        return true;
    }


    @Override
    public Sheet getSheet(String name) {
        return null;
    }

    @Override
    public boolean IsNotSheet() {
        return true;
    }
}
