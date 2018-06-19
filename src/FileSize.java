public final class FileSize {

    private final String[] size;
    private final String[] filePath;

    public FileSize(String line) {

        final Commands treatedCommand = new Commands(line);// Получаем значения флагов и пути к файлам

        filePath = treatedCommand.getPathFile();
        final boolean h = treatedCommand.getFlagH();
        final boolean c = treatedCommand.getFlagC();
        final boolean si = treatedCommand.getFlagSi();

        final DifferentSizes receivedSize = new DifferentSizes(c, filePath);// Получаем размеры файлов в байтах

        final Flags treatedSize = new Flags(h, si, receivedSize.getSize());// Обрабатываем размеры файлов с учётом флагов

        size = treatedSize.getSize();
    }

    public String[] getFilesSize() {//метод для получения размера файлов
        return size;
    }

    public String[] getFilePath() {//метод для получения пути файлов
        return filePath;
    }
}