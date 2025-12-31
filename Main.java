import linear.HashTable;
import nonlinear.Tree;

public class Main {
    public static void main(String[] args) {
        var tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        System.out.println(tree.find(3));
        tree.print();
    }
}