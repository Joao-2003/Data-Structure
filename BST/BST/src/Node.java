public class Node {
    public int data;
    public Node left, right, parent;
    public int height;
    public boolean color; // true for red, false for black

    public Node(int data) {
        this.data = data;
        left = right = parent = null;
        height = 1; // New nodes are initially added at height 1
        color = true; // New nodes are initially red
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + ", parent=" + parent + ", height=" + height + ", color=" + (color ? "Red" : "Black") + '}';
    }
}