import java.util.Arrays;

final class StringList1 {
    private int size = 0;
    private String[] stringList = new String[100];

    boolean add(final String listItem) {
        if (contains(listItem)) {
            return false;
        }
        stringList[size++] = listItem;
        return true;
    }

    String[] get() {
        return Arrays.copyOfRange(stringList, 0, size);
    }

    boolean contains(final String listItem) {
        for (int i = 0; i < size; i++) {
            if (listItem.equals(stringList[i])) {
                return true;
            }
        }
        return false;
    }

    boolean delete(final String listItem) {
        for (int i = 0; i < size; i++) {
            if (listItem.equals(stringList[i])) {
                shiftLeft(i);
                return true;
            }
        }
        return false;
    }

    private void shiftLeft(final int index) {
        if (size - index >= 0) {
            System.arraycopy(stringList, index + 1, stringList, index, size - index);
        }
        size--;
    }
}
