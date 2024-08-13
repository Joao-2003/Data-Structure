public class Node {
    String data;
    Node previous, next;

    public Node(String data, Node previous, Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public Node(String data) {
        this(data, null, null);
    }
}
