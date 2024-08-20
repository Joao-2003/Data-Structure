public class DinamicStack {
    Node top;
    int size;

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

    public void push(String info) {
        Node newNode = new Node(info);
        if (this.top != null){
            newNode.prev = this.top;
            this.top.next = newNode;
        }
        this.top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String info = this.top.info;
        this.top = this.top.prev;
        if (this.top != null) {
            this.top.next = null;
        }
        size--;
        return info;
    }

    public String peek() {
        if (isEmpty()) {
            return "-1";
        }
        return this.top.info;
    }
}