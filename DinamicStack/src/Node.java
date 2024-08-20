public class Node {
    String info;
    Node next;
    Node prev;

    public Node(String info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}