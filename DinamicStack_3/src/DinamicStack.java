public class DinamicStack {
    Node top;
    int size;

    public void print(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.info);
            temp = temp.prev;
        }
    }

    public DinamicStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(int info) {
        Node newNode = new Node(info);
        if (this.top != null){
            newNode.prev = this.top;
            this.top.next = newNode;
        }
        this.top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -0;
        }
        int info = this.top.info;
        this.top = this.top.prev;
        if (this.top != null) {
            this.top.next = null;
        }
        size--;
        return info;
    }

    public int peek() {
        if (isEmpty()) {
            return -0;
        }
        return this.top.info;
    }
}