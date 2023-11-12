package Rooms;

import java.util.ArrayList;
import java.util.Scanner;

public class KMaruRoom implements IRoom {
    String code;
    String name;
    ArrayList<Sheet> sheets = new ArrayList<>();
    @Override
    public void matches(String kwd) {

    }

    @Override
    public void print() {
        System.out.format("%s %s", code, name);
    }

    @Override
    public void read(Scanner scanner) {
        code = scanner.next();
        name = scanner.next();
        while (scanner.hasNext()){
            sheets.add(new Sheet(scanner.next()));
        }
    }
}
