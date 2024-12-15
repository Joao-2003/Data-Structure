public class Node {
    public int data;
    public Node left, right;
    public int height;

    public Node(int data) {
        this.data = data;
        left = right = null;
        height = 1; // New nodes are initially added at height 1
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + ", height=" + height + '}';
    }
}