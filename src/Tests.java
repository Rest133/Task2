import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void FileSize() {
        assertArrayEquals(
                new String[]{"41,30", "8,47"},
                new FileSize("du files/ files/doc/doc1.txt").getFilesSize()//Проверка работы программы
        );

        assertArrayEquals(
                new String[]{"41,30KB", "8,47KB"},
                new FileSize("du -h files/ files/doc/doc1.txt").getFilesSize()//Проверка размера папки и файла
        );
        assertArrayEquals(
                new String[]{"41,30", "11,76", "53,06"},
                new FileSize("du -c files/ files/doc/doc2.txt").getFilesSize()//Проверка суммарности
        );
        assertArrayEquals(
                new String[]{"42,29KB", "714,00B", "20,86KB", "8,67KB", "72,54KB"},
                new FileSize("du -h --si -c files/ files/new_file.txt" +
                        " files/doc/doc3.txt files/doc/doc1.txt").getFilesSize()//Несколько файлов
        );
        assertArrayEquals(
                new String[]{"0,00B", "0,00B"},
                new FileSize("du -h --si -c files/empty.txt").getFilesSize()//Проверка пустых файлов
        );

        try {
            new FileSize("du dvetter/ files/books d/documents/doc1.txt");//Далее проверки на различные виды ошибок
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            new FileSize("files/ files/work files/doc/doc1.txt");
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            new FileSize("-c --si files/ files/work files/doc/doc1.txt");
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            new FileSize("du -c -h");
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            new FileSize("du -c -c -c files/ files/work files/doc/doc1.txt");
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            new FileSize("du");
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    }


