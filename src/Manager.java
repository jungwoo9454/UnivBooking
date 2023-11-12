import Booking.BookingInfo;
import Booking.User;
import Rooms.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<IRoom> roomList = new ArrayList<>();

    private static Manager instance = new Manager();
    private Manager() {
    }

    public static Manager getInstance() {
        return instance;
    }
    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e)
        {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }

    void printAllRooms()
    {
        for(var room : roomList)
            room.print();
    }

    void readData()
    {
        Scanner file = openFile("InputData/study_input.txt");
        while (file.hasNext())
        {
            IRoom room = null;
            switch (file.nextInt())
            {
                case 1:
                    room = new TeamProjectRoom(1);
                    break;
                case 2:
                    room = new AgoraRoom(2);
                    break;
                case 3:
                    room = new KMaruRoom(3);
                    break;
            }
            room.read(file);
            roomList.add(room);
        }
    }

    IRoom findRoom(String name)
    {
        for(var room : roomList)
        {
            if(room.matches(name))
                return room;
        }
        return null;
    }

    void Search()
    {
        System.out.println("검색 방법을 선택하세요.");
        System.out.print("(1) 장소(좌석) 검색 (2) 예약검색 (기타) 나가기");
        int select = scanner.nextInt();
        String name;
        switch (select)
        {
            case 1:
                System.out.print("장소명 또는 코드, 좌석 번호를 입력하세요 : ");
                name = scanner.next();
                for(var room : roomList)
                    if(room.matches(name))
                        room.bookingPrint();
                break;
            case 2:
                System.out.print("예약자의 학번 또는 이름을 입력하세요 : ");
                name = scanner.next();
                for(var room : roomList)
                    if(room.bookingMatches(name))
                        room.bookingPrint();
                break;
        }

    }

    void Booking()
    {

        System.out.print("예약할 장소의 이름 또는 코드를 입력해 주세요 : ");
        IRoom room = null;
        while (true)
        {
            String name = scanner.next();
            room = findRoom(name);

            if(room != null)
                break;
            else {
                System.out.print("해당 장소의 이름 또는 코드를 가진 곳이 없습니다. 다시 입력해 주세요 : ");
            }
        }

        Sheet sheet = null;
        if(room.IsNotSheet() == false)
        {
            room.print();
            System.out.print("좌석을 입력해 주세요 : ");
            while (true)
            {
                String sheetname = scanner.next();

                sheet = room.getSheet(sheetname);

                if(sheet != null)
                    break;
                else {
                    System.out.print("해당되는 좌석이 없습니다. 다시 입력해 주세요 : ");
                }
            }
        }

        System.out.print("예약자의 학번을 입력해주세요. : ");
        String code = scanner.next();
        System.out.print("예약자의 이름을 입력해주세요. : ");
        String name = scanner.next();

        User user = new User(code, name);

        while (true)
        {
            System.out.print("예약 날짜를 입력해 주세요.(예시 2023-10-10) : ");
            String date = scanner.next();
            System.out.print("예약 시간을 입력해 주세요.(예시 10-12) : ");
            String time = scanner.next();

            String[] date_split = date.split("-");
            String[] time_split = time.split("-");
            int year = Integer.parseInt(date_split[0]);
            int month = Integer.parseInt(date_split[1]);
            int day = Integer.parseInt(date_split[2]);

            int starttime = Integer.parseInt(time_split[0]);
            int endtime = Integer.parseInt(time_split[1]);

            if(room.IsBooking(sheet, user, year, month, day, starttime, endtime))
            {
                System.out.println("예약이 성공적으로 이루어졌습니다!");
                break;
            }else {
                System.out.println("해당 시간에 이미 예약이 있습니다. 다른 날짜를 선택해 주세요.");
            }
        }
    }

    void Check()
    {
        System.out.print("조회할 장소의 이름 또는 코드를 입력해 주세요.(전체를 조회하려면 \"ALL\"을 입력하세요) : ");
        String name = scanner.next();

        if(name.equals("ALL"))
        {
            for(var room : roomList)
                room.bookingPrint();
        }else {
            IRoom room = findRoom(name);

            if(room.IsNotSheet() == false)
            {
                System.out.print("조회할 좌석번호를 입력해 주세요.(전체를 조회하려면 \"ALL\"을 입력하세요) : ");
                String sheetname = scanner.next();
                if(sheetname.equals("ALL"))
                    room.bookingPrint();
                else
                    room.getSheet(sheetname).print();
            }else {
                room.bookingPrint();
            }

        }
    }

    public void run()
    {
        readData();
        while (true)
        {
            System.out.println("(1)예약 (2)검색 (3)조회 (기타)종료");
            switch (scanner.nextInt())
            {
                case 1:
                    Booking();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    Check();
                    break;
                default:
                    return;
            }
        }
    }
}
