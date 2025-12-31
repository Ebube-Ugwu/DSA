package  nonlinear;


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
        if (root.value == value) {
            return;
        }
        Node current = root;
        while (true) {
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            } else {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }
        }
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
        if (value > root.value) {
        return find(value, root.rightChild);
        }
        return find(value, root.leftChild);
    }

    private boolean isLeaf(Node node) {
        if (node == null) {
            return true;
        }
        return (node.leftChild == null && node.rightChild == null);
    }

    private boolean isEmpty() {
        return root == null;
    }
}