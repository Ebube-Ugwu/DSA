package linear;

public class Array {
    private int count = 0;
    private int[] items;
    
    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (count >= items.length) {
            grow();
        }
        items[count++] = item;
    }
    public int length() {
        return count;
    }

    public int itemAt(int index) {
        if (index >= items.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return items[index];
    }

    public void removeAt(int index) {
        if (index >= items.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        shift(index);
        count--;
    }

    public int indexOf(int target) {
        int index = 0;
        for (var item : items) {
            if (item == target) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private void shift(int index) {
        for (int i = index; i < count; i++) {
            items[i] = items[i+1];
        }
    }


    private void grow() {
        int[] newArray = new int[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }
}