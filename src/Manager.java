import Rooms.AgoraRoom;
import Rooms.IRoom;
import Rooms.KMaruRoom;
import Rooms.TeamProjectRoom;

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
                    room = new TeamProjectRoom();
                    break;
                case 2:
                    room = new AgoraRoom();
                    break;
                case 3:
                    room = new KMaruRoom();
                    break;
            }
            room.read(file);
            roomList.add(room);
        }
    }

    public void run()
    {
        while (true)
        {
            readData();
            printAllRooms();
            System.out.println("(1)검색 (2)예약 (3)조회 (기타)종료");
            switch (scanner.nextInt())
            {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    return;
            }
        }
    }
}
