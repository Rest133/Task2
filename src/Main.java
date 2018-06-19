import java.util.Scanner;

public class Main {

    public static void main(String[] args) {    // Метод для работы с консолью
        try {
            final Scanner sc = new Scanner(System.in);
            final FileSize database = new FileSize(sc.nextLine());

            final String[] size = database.getFilesSize();
            final String[] filePath = database.getFilePath();
            final int length = size.length;
            for (int i = 0; i < length; i++) {
                System.out.println(filePath[i] + ": " + size[i]);
            }
        } catch (IllegalArgumentException e) {
            System.exit(1);
        }
    }

}