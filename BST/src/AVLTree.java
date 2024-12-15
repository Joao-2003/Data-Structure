public class AVLTree extends BST {

    public AVLTree() {
        super();
    }

    @Override
    public void insert(int data) {
        this.root = insert(this.root, new Node(data));
    }

    private Node insert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.data < root.data) {
            root.left = insert(root.left, newNode);
        } else if (newNode.data > root.data) {
            root.right = insert(root.right, newNode);
        } else {
            return root; // Duplicate keys not allowed
        }

        updateHeight(root);
        return balance(root);
    }

    @Override
    public Node delete(int key) {
        this.root = delete(this.root, key);
        return this.root;
    }

    private Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                Node temp = min();
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        if (root == null) {
            return null;
        }

        updateHeight(root);
        return balance(root);
    }

    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            System.out.println("\nTree before balance");
            printTree();
            printBalanceFactors();
            System.out.println("\nRight rotation");
            return rotateRight(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            System.out.println("Tree before balance");
            printTree();
            printBalanceFactors();
            System.out.println("\nLeft-Right rotation");
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            System.out.println("\nTree before balance");
            printTree();
            printBalanceFactors();
            System.out.println("\nLeft rotation");
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            System.out.println("\nTree before balance");
            printTree();
            printBalanceFactors();
            System.out.println("\nRight-Left rotation");
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    public void printBalanceFactors() {
        System.out.println("Balance factors:");
        printBalanceFactors(this.root);
    }

    private void printBalanceFactors(Node node) {
        if (node != null) {
            printBalanceFactors(node.left);
            System.out.println("Node " + node.data + ": " + getBalance(node));
            printBalanceFactors(node.right);
        }
    }

    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }
}