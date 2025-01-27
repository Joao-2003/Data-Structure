import java.util.Stack;

public class BST {
    protected Node root;

    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean search(int key) {
        return search(this.root, key);
    }

    private boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }else if (root.data == key) {
            return true;
        }else if (root.data > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public void insert(int data) {
        insert(new Node(data));
    }

    public void insert(Node newNode) {
        this.root = insert(this.root, newNode);
    }

    private Node insert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.data < root.data) {
            root.left = insert(root.left, newNode);
        } else if (newNode.data > root.data) {
            root.right = insert(root.right, newNode);
        }
        return root;
    }

    public Node delete(int key) {
        return delete(this.root, key);
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
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root.data = min(root.right).data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public Node min() {
        return min(this.root.right);
    }

    private Node min(Node root) {
        if (root == null){
            return null;
        }
        if (root.left != null){
            return min(root.left);
        }
        return root;
    }

    public Node max() {
        return max(this.root.left);
    }

    private Node max(Node root) {
        if (root == null){
            return null;
        }
        if (root.right != null){
            return max(root.right);
        }
        return root;
    }

    public void inorder(){
        inorder(this.root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(){
        preorder(this.root);
        System.out.println();
    }

    private void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(){
        postorder(this.root);
        System.out.println();
    }

    private void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public boolean isLeaf(Node root) {
        return root != null && root.left == null && root.right == null;
    }

    public boolean hasTwoChildren(Node root) {
        return root != null && root.left != null && root.right != null;
    }

    public int height() {
        if (this.root == null) {
            return 0;
        }
        return height(this.root);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public BST copyTree() {
        BST copy = new BST();
        copy.root = copyNode(this.root);
        return copy;
    }

    private Node copyNode(Node root) {
        if (root == null) {
            return null;
        }
        Node newNode = new Node(root.data);
        newNode.left = copyNode(root.left);
        newNode.right = copyNode(root.right);
        return newNode;
    }

    //Exercise 1
    public int countNodes(){
        if (this.root == null){
            return 0;
        }
        return countNodes(this.root);
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //Exercise 2
    public int countLeaves(){
        if (this.root == null){
            return 0;
        }
        return countLeaves(this.root);
    }

    private int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    //Exercise 3
    public void iterativeInsert(Node newNode) {
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        Node current = this.root;
        while (true) {
            if (newNode.data == current.data) {
                break;
            }
            if (newNode.data < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    //Exercise 4
    public BST mirror() {
        BST mirrored = new BST();
        mirrored.root = invert(this.root);
        return mirrored;
    }

    private Node invert(Node root) {
        if (root == null) {
            return null;
        }
        Node newNode = new Node(root.data);
        newNode.left = invert(root.right);
        newNode.right = invert(root.left);
        return newNode;
    }

    //Exercise 5
    public boolean alike(BST tree) {
        return alike(this.root, tree.getRoot());
    }

    private boolean alike(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return alike(root1.left, root2.left) && alike(root1.right, root2.right);
    }

    //Exercise 6
    public boolean equals(BST tree) {
        return equals(this.root, tree.getRoot());
    }

    private boolean equals(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }

    //Exercise 7
    public boolean strictlyBinary() {
        return strictlyBinary(this.getRoot());
    }

    private boolean strictlyBinary(Node root) {
        if (root == null) {
            return true;
        }
        if (isLeaf(root)) {
            return true;
        }
        if (hasTwoChildren(root)) {
            return strictlyBinary(root.left) && strictlyBinary(root.right);
        }
        return false;
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int gaps = 128;
        boolean isRowEmpty = false;
        String separator = "----------------------------------------------------------------------------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}

