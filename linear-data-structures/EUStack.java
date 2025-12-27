import java.util.*;

public class EUStack {
    private Array items = new Array(10);

    public int peek() {
        return items.itemAt(items.length() - 1);
    }

    public int pop() {
        int lastIndex = items.length() - 1;
        int item = items.itemAt(lastIndex);
        items.removeAt(lastIndex);
        return item;
    }

    public void push(int item) {
        items.insert(item);
    }

    public boolean isEmpty() {
        return items.length() == 0;
    }

    public String stringReverse(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char s : str.toCharArray()) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public boolean stringIsBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (isLeftBracket(c)) {
                stack.push(c);
            } else if (isRightBracket(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char leftBracket = stack.pop();
                if (!bracketsMatch(leftBracket, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean bracketsMatch(char leftBracket, char rightBracket) {
        Map<Character, Character> bracketPairs = Map
                .of('<','>', '(',')', '[', ']', '{', '}');
        return bracketPairs.get(leftBracket) == rightBracket;
    }

    private boolean isLeftBracket(char c) {
        return c == '<' || c == '(' ||
               c == '[' || c == '{' ;
    }

    private  boolean isRightBracket(char c) {
        return c == '>' || c == ')' ||
                c == ']' || c == '}';
    }
}
