import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public void addFirst(int value) {
        if (isEmpty()) {
            first = new Node(value);
            last = first;
            size++;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void addLast(int value) {
        if (isEmpty()) {
            first = new Node(value);
            last = first;
            size++;
            return;
        }
        Node newNode = new Node(value);
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (hasOnlyOne()) {
            first = null;
            last = null;
            size--;
            return;
        }
        first = first.next;
        size--;
    }

    private boolean hasOnlyOne() {
        return first == last;
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (hasOnlyOne()) {
            first = null;
            last = null;
            size--;
            return;
        }
        Node lastNode = first;
        Node penult = null;
        while (lastNode.next != null) {
            penult = lastNode;
            lastNode = lastNode.next;
        }
        last = penult;
        penult.next = null;
        size--;
    }

    public boolean contains(int value) {
        if (isEmpty()) {
            return false;
        }
        Node current = first;
        while (current != null) {
            if (current.value == value)  {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(int value) {
        if (isEmpty()) {
            return -1;
        }
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public List<Integer> toArray() {
        var array = new ArrayList<Integer>();
        Node current = first;
        while (current != null) {
            array.add(current.value);
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty() || hasOnlyOne()) {
            return;
        }

        Node previous = first;
        Node current = previous.next;
        while(current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int kThNodeFromEnd(int k) {
        if (isEmpty()) {
            return -1;
        }
        if (hasOnlyOne()) {
            return first.value;
        }

        Node current = first;
        Node step = first;
        for (int i = k-1; i > 0; i--) {
            step = step.next;
        }
        while (step != last) {
            current = current.next;
            step = step.next;
        }
        return current.value;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    private boolean isEmpty() {
        return first == null;
    }
}