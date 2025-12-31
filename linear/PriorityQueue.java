package linear;


public class PriorityQueue {
    private int[] items = new int[10];
    private int count = 0;
    private int first = 0;
    private int last = 0;

    public void enqueue(int item) {
        if (isEmpty()) {
            items[count++] = item;
            return;
        }
        if (isFull()) {
            resize();
        }
        int index = count -1;
        if (item < items[index]) {
            while(item < items[index]) {
                items[index + 1] = items[index];
                items[index] = item;
                index--;
            }
        } else {
            items[count] = item;
        }
        last = count;
        count++;
    }

    public int dequeue() {
        count--;
        return items[first++];
    }

    private void resize() {
        int[] newArray = new int[items.length * 2];
        System.arraycopy(items, 0, newArray, 0, items.length);
        this.items = newArray;
    }

    private boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
