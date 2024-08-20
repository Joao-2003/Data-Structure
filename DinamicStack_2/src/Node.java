public class Node {
    byte info;
    Node next;
    Node prev;

    public Node(byte info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}