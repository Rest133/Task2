public class Commands {

    private boolean h, c, si;
    private final String[] pathToFile;

    public Commands(String line) {
        final String[] command = line.split(" ");
        final int length = command.length;

        // В случае, если не были введены имена файлов/директорий или отсутствует ключевое слово du, выдать код ошибки 1
        if (length < 2 || !command[0].equals("du")) {
            throw new IllegalArgumentException();
        }


        h = false;// Проверка флагов h,c,si
        c = false;
        si = false;
        boolean stop = false;
        int ind = 0;

        while (!stop) {
            if (++ind == length) {
                throw new IllegalArgumentException();
            }

            switch (command[ind]) {
                case "-h":
                    if (h) {
                        throw new IllegalArgumentException();
                    }
                    h = true;
                    break;
                case "-c":
                    if (c) {
                        throw new IllegalArgumentException();
                    }
                    c = true;
                    break;
                case "--si":
                    if (si) {
                        throw new IllegalArgumentException();
                    }
                    si = true;
                    break;
                default:
                    stop = true;
            }
        }


        final int newLength = length - ind;// Добавление в поле filePath путей к файлам

        if (c) {
            pathToFile = new String[newLength + 1];
        } else {
            pathToFile = new String[newLength];
        }

        final int shift = ind;
        for (int i = 0; i < newLength; i++) {
            pathToFile[i] = command[i + shift];
        }
    }

    public String[] getPathFile() {
        return pathToFile;
    }

    public boolean getFlagC() {
        return c;
    }

    public boolean getFlagSi() {
        return si;
    }

    public boolean getFlagH() {
        return h;
    }

}