public class Tree {
    private Node root;
    private class  Node {
        public int value;
        public Node rightChild;
        public Node leftChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
            return;
        }
        Node current = root;
        while (current != null) {
            if (isGreater(value, current.value)) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        current = newNode;
        System.out.println(current.rightChild);
    }

    public void print() {
        print(root);
    }
   private void print(Tree.Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        print(root.leftChild);
        print(root.rightChild);
    }

 public boolean find(int value) {
        return find(value, root);
    }

    private boolean find(int value, Tree.Node root) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        if (isGreater(value, root.value)) {
        return find(value, root.rightChild);
        }
        return find(value, root.leftChild);
    }

    private boolean isGreater(int value, int value2) {
        return value > value2;
    }   

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private boolean isEmpty() {
        return root == null;
    }
}