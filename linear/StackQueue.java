package linear;


import java.util.Stack;

public class StackQueue {
    private Stack<Integer> enStack = new Stack<>();
    private Stack<Integer> deStack = new Stack<>();

    public void enqueue(int item) {
        enStack.push(item);
    }

    public int dequeue() {
        if (deStack.isEmpty()) {
            moveStack();
        }
        return deStack.pop();
    }

    public boolean isEmpty() {
        return enStack.isEmpty() && deStack.isEmpty();
    }

    private void moveStack() {
        while (!enStack.isEmpty()) {
            deStack.push(enStack.pop());
        }
    }
}
