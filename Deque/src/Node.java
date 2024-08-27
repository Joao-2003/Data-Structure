public class Node {
    Person person;
    Node next;
    Node prev;

    public Node(Person person) {
        this.person = person;
        this.next = null;
        this.prev = null;
    }
}
