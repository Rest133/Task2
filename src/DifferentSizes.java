import java.io.File;

public class DifferentSizes {

    private final long[] size;

    public DifferentSizes(boolean c, String[] filePath) {
        int length = filePath.length;
        size = new long[length];
        long sum = 0;
        if (c) {
            length--;
        }

        for (int i = 0; i < length; i++) {
            File currentFile = new File(filePath[i]); // Перебор папок/файлов

            if (!currentFile.exists()) {
                throw new IllegalArgumentException();// Есди файл не существует, выдаваемый код ошибки будет 1
            }

            // Вычисление размера файла/каталога
            if (currentFile.isFile()) {
                size[i] = currentFile.length();
            } else {
                size[i] = sizeOfDirectory(currentFile);
            }

            sum += size[i];
        }


        if (c) {
            size[length] = sum;// Посчитать суммарный объём, если был указан флаг "-с"
        }
    }

    private long sizeOfDirectory(File directory) {
        long size = 0;
        for (File searchingFile : directory.listFiles()) {
            if (searchingFile.isFile()) {
                size += searchingFile.length();
            } else {
                size += sizeOfDirectory(searchingFile);
            }
        }
        return size;// Метод для вычисления размера каталога
    }

    public long[] getSize() {
        return size; // Метод для получения в виде массива размеров всех запрашиваемых файлов
    }
}