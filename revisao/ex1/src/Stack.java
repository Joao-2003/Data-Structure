import java.util.Arrays;

public class Stack {
    int top;
    String[] elements = new String[100];
    int size;

    public Stack() {
        top = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull(){
        return (top == 100);
    }

    public void push(String element) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            size++;
            elements[top] = element;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            //System.out.println("Element popped: " + elements[top]);
            top--;
            size--;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return elements[top];
        }
    }

    public int size() {
        return size;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i > -1; i--) {
                System.out.print(elements[i]);
            }
        }
    }


    public void destroyStack() {
        top = -1;
        size = 0;
    }

//    @Override
//    public String toString() {
//
//        StringBuilder sb = new StringBuilder("[");
//        for (int i = top; i > -1; i--) {
//            sb.append(elements[i]);
//            if (i != 0) sb.append(", ");
//        }
//        sb.append("]");
//
//
//        return sb.toString();
//    }
}
