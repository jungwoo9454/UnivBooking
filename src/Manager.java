import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
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
    public void run()
    {

    }
}
