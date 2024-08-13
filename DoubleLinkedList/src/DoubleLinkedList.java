public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void size() {
        System.out.println("Tamanho da lista: "+this.size);
    }

    public void addToHead(String data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        } else {
            this.head = this.tail = newNode;
        }
        this.size++;
    }

    public void addToTail(String data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        } else {
            this.tail = this.head = newNode;
        }
        this.size++;
    }

    public void print(){
        for(Node node = this.head; node != null; node = node.next){
            System.out.print(node.data + "-");
        }
        if (isEmpty()){
            System.out.println("null");
        }
        System.out.println();
    }

    public void search(String data) {
        boolean found = false;
        for (Node node = this.head; node != null; node = node.next) {
            if (data.equals(node.data)) {
                found = true;
            }
        }
        if (!found) {
            System.out.println(data + " nao encontrado");
        } else {
            System.out.println(data + " encontrado");
        }

    }

    public void removeFromHead() {
        if (!isEmpty()) {
            if (this.head == this.tail) {
                this.head = this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.previous = null;
            }
            this.size--;
        }
    }

    public void removeFromTail() {
        if (!isEmpty()) {
            if (this.tail == this.head) {
                this.head = this.tail = null;
            } else {
                this.tail = this.tail.previous;
                this.tail.next = null;
            }
            this.size--;
        }

    }

    public void delete(int index) {
        if (!isEmpty() && index >= 0 && index < this.size) {
            if (index == 0) {
                removeFromHead();
            } else if (index == this.size - 1) {
                removeFromTail();
            } else {
                Node temp = this.head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                this.size--;
            }
        }
    }

    public void delete(String data) {
        if (!isEmpty()) {
            if (this.head == this.tail && data.equals(this.head.data)) {
                this.head = this.tail = null;
            } else if(this.head.data.equals(data)) {
                this.removeFromHead();
            } else if(this.tail.data.equals(data)){
                this.removeFromTail();
            } else {
                Node temp = this.head;
                for(; temp!=null; temp = temp.next);
                if (temp.data.equals(data)) {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                }
                this.size--;
            }

        }
    }

    public void insert(int index, String data) {
        if (!isEmpty()) {
            Node newNode = new Node(data);
            if (index == 0){
                addToHead(data);
            } else if(index == this.size-1){
                addToTail(data);
            } else if (index > 0 && index < this.size-1) {
                Node temp = this.head;
                for(int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                newNode.previous = temp;
                temp.next.previous = newNode;
                temp.next = newNode;
                this.size++;
            }

        }
    }
}

