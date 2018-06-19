public class Flags {

    private final String[] size;

    public Flags(boolean h, boolean si, long[] byteSize) {


        int div = 1000;// Обработка флага --si
        if (!si) {
            div = 1024;
        }

        final int length = byteSize.length;// Обработка флага -h
        size = new String[length];
        if (h) {
            final String[] prefix = new String[]{"B", "KB", "MB", "GB"};

            for (int j = 0; j < length; j++) {
                double currentSize = byteSize[j];
                int prefixNumber = 0;

                while (currentSize > div) {// Перевод в соответствующие единицы измерения
                    currentSize /= div;
                    prefixNumber++;
                }

                final String newSize = String.format("%.2f", currentSize) + prefix[prefixNumber];
                size[j] = newSize;
            }
        } else {
            for (int j = 0; j < length; j++) {
                final String newSize = String.format("%.2f", (double) byteSize[j] / div);
                size[j] = newSize;
            }
        }
    }

    public String[] getSize() {
        return size;
    }
}