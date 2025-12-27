import java.util.*;
import java.util.LinkedList;

public class HashTable {
    private final LinkedList<Entry>[] entries = new LinkedList[10];
    private class Entry {
        private final int key;
        private final String value;

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    public void put(int key, String value) {
        int index = getIndex(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<Entry>();
        }
        var newEntry = new Entry(key, value);
        entries[index].add(newEntry);
    }

    private int getIndex(int key) {
        return key % entries.length;
    }

    public String get(int key) {
        int index = getIndex(key);
        if (isEmpty(key)) {
            throw new NoSuchElementException("key does not exist");
        }
        for (Entry entry : entries[index]) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (isEmpty(key)) {
            throw new NoSuchElementException("key does not exist");
        }
        entries[index].removeIf(entry -> entry.getKey() == key);
    }

    private boolean isEmpty(int key) {
        return entries[getIndex(key)] == null;
    }

    public boolean containsKey(int key) {
        int index = getIndex(key);
        if (isEmpty(key)) {
            return false;
        }
        for (Entry entry : entries[index]) {
            if (entry.getKey() == key) {
                return true;
            }
        }
        return false;
    }

    public char firstNonRepeatChar(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (var ch : str.toCharArray()) {
            int count = charFrequencyMap.getOrDefault(ch, 0) + 1;
            charFrequencyMap.put(ch, count);
        }
        for (var ch : str.toCharArray()) {
            if (charFrequencyMap.get(ch) == 1) {
                return ch;
            }
        }
        return '0';
    }

    public char firstRepeatChar(String str) {
        Set<Character> set = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return '0';
    }
}
