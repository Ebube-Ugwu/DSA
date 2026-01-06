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

    public Node getRoot() {
        return root;
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
        return node.leftChild == null && node.rightChild == null;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public int min() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return min(root);
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }
        var left = root.leftChild == null ? root.value : min(root.leftChild);
        var right = root.rightChild == null ? root.value : min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int height() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return height(root);
    }

    private int height(Node root) {
        if (isLeaf(root) || root == null) {
            return 0; // leaf nodes have a height of zero   
        }
        var leftHeight = root.leftChild == null ? 0 : height(root.leftChild);
        var rightHeight = root.rightChild == null ? 0 : height(root.rightChild);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isEqual(Tree tree) {
        return isEqual(root, tree.getRoot());
    }

    private boolean isEqual(Node root, Node otherRoot) {
        if (root == null && otherRoot == null) {
            return true;
        }
        if (root == null || otherRoot == null) {
            return false;
        }
        if (root.value != otherRoot.value) {
            return false;
        }
        return isEqual(root.leftChild, otherRoot.leftChild)
            && isEqual(root.rightChild, otherRoot.rightChild);
    }
}