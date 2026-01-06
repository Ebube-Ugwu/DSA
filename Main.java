import nonlinear.Tree;

public class Main {
    public static void main(String[] args) {
        var tree = new Tree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        var otherTree = new Tree();
        otherTree.insert(2);
        otherTree.insert(1);
        otherTree.insert(3);
        otherTree.insert(4);
        otherTree.insert(6);
        System.out.println(tree.isEqual(otherTree));
        
    }
}