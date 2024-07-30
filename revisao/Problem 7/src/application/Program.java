package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Program {
    public void run() {
        try {
            Queue<Integer> myQueue = new LinkedList<>();

            for (int i = 0; i < 21; i++) {
                myQueue.add(i);
            }
            System.out.print("Straight queue = ");
            System.out.println(myQueue);
            reverseQueue(myQueue);
            System.out.print("Reversed queue = ");
            System.out.println(myQueue);
        } catch (Exception e) {
            System.err.println("Opps! An Error occurred! Do try it again!");
        }
    }

    private void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> auxStack = new Stack<>();
        while (!queue.isEmpty()) {
            auxStack.push(queue.remove());
        }
        while (!auxStack.isEmpty()) {
            queue.add(auxStack.pop());
        }
    }
}
