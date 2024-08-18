public class CircularDoubleLinkedList {
    public Node sentinel;
    public int size;

    public CircularDoubleLinkedList() {
        this.sentinel = new Node(Integer.MIN_VALUE);
        this.sentinel.next = this.sentinel;
        this.sentinel.previous = this.sentinel;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public int size() {
        return this.size;
    }

    public void addToHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.sentinel.next;
        newNode.previous = this.sentinel;
        this.sentinel.next.previous = newNode;
        this.sentinel.next = newNode;
        if (this.size == 0) {
            this.sentinel.previous = newNode;
        }
        this.size++;
    }

    public void addToTail(int data) {
        Node newNode = new Node(data);
        newNode.next = this.sentinel;
        newNode.previous = this.sentinel.previous;
        this.sentinel.previous.next = newNode;
        this.sentinel.previous = newNode;
        if (this.size == 0) {
            this.sentinel.next = newNode;
        }
        this.size++;
    }

    public void removeFromHead() {
        if (!isEmpty()) {
            Node first = this.sentinel.next;
            this.sentinel.next = first.next;
            first.next.previous = this.sentinel;
            this.size--;
            if (this.size == 0) {
                this.sentinel.previous = this.sentinel;
            }
        }
    }

    public void removeFromTail() {
        if (!isEmpty()) {
            Node last = this.sentinel.previous;
            this.sentinel.previous = last.previous;
            last.previous.next = this.sentinel;
            this.size--;
            if (this.size == 0) {
                this.sentinel.next = this.sentinel;
            }
        }
    }

    public void delete(int index) {
        if (!isEmpty() && index >= 0 && index < this.size) {
            Node temp = this.sentinel.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            this.size--;
        }
    }



    public void insert(int index, int data) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addToHead(data);
        } else if (index == this.size) {
            addToTail(data);
        } else {
            Node newNode = new Node(data);
            Node temp = this.sentinel.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp;
            newNode.previous = temp.previous;
            temp.previous.next = newNode;
            temp.previous = newNode;
            this.size++;
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if (data - this.sentinel.next.data <= this.sentinel.previous.data - data){
            Node aux = this.sentinel.next;
            while (data > aux.next.data){
                aux = aux.next;
            }
            newNode.next = aux.next;
            newNode.previous = aux;
            aux.next.previous = newNode;
            aux.next = newNode;
            this.size++;
        } else {
            Node aux = this.sentinel.previous;
            while (data < aux.previous.data){
                aux = aux.previous;
            }
            newNode.previous = aux.previous;
            newNode.next = aux;
            aux.previous.next = newNode;
            aux.previous = newNode;
            this.size++;
        }
    }

    public void printIncreasing() {
        Node node = this.sentinel.next;
        while (node != this.sentinel) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void printDecreasing() {
        Node node = this.sentinel.previous;
        while (node != this.sentinel) {
            System.out.print(node.data + " ");
            node = node.previous;
        }
        System.out.println();
    }

    public boolean search(int data) {
        Node node = this.sentinel.next;
        while (node != this.sentinel) {
            if (data == node.data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

}

