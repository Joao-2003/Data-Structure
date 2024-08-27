public class Deque {
    Node head;
    Node tail;
    int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void print(){
        if (isEmpty()){
            System.out.println("DEQUE VAZIO");
        } else {
            Node aux = head;
            System.out.println("Elementos no Deque:");
            for (int i = 0; i < this.size(); i++) {
                System.out.print(aux.person.id + " ");
                aux = aux.next;
            }
            System.out.println();
        }
    }

    void insertFirst(Person p) {
        Node newNode = new Node(p);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    void insertLast(Person p) {
        Node newNode = new Node(p);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            head.prev = tail;
        }
        size++;
    }

    Person removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque Vazio");
            return null;
        } else {
            Person person = head.person;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = tail;
                tail.next = head;
            }
            size--;
            return person;

        }
    }

    Person removeLast() {
        if (isEmpty()) {
            System.out.println("Deque Vazio");
            return null;
        } else {
            Person person = tail.person;
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = head;
                head.prev = tail;
            }
            size--;
            return person;
        }
    }


}
