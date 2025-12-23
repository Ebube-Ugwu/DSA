public class Main {
    public static void main(String[] args)  {
        var hashTable = new HashTable();
        hashTable.put(1, "one");
        hashTable.put(2, "two");
        hashTable.put(3, "three");
        System.out.println(hashTable.containsKey(2));
    }
}