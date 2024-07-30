package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Program {
    private Random rand = new Random();

    public void run() {
        try {
            Queue<Integer> myQueue = new LinkedList<>();
            Stack<Integer> myStack = new Stack<>();

            for(int i = 0; i < 1001; i++) {
                myQueue.add(drawnPositiveNumber());
            }
            for(int i = 0; i < 1001; i++) {
                myQueue.add(drawnNegativeNumber());
            }

            System.out.print("Start queue = ");
            System.out.println(myQueue);
            System.out.print("Start stack = ");
            System.out.println(myStack);
            System.out.println();
            while (!myQueue.isEmpty()) {
                Integer num = myQueue.poll();
                if (num >= 0) {
                    myStack.add(num);
                } else {
                    if (!myStack.isEmpty()) {
                        System.out.print("Removing from stack= ");
                        System.out.println(myStack.pop()); // Remove do stack
                    } else {
                        System.out.println("Stack is empty. Cannot remove.");
                    }
                }
            }

            System.out.print("End queue = ");
            System.out.println(myQueue);
            System.out.print("End stack = ");
            System.out.println(myStack);

        } catch (Exception e) {
            System.out.println("Error! Something wrong occurred!");
        }
    }

    private int drawnPositiveNumber() {
        return rand.nextInt(1000000000);
    }

    private int drawnNegativeNumber() {
        return -rand.nextInt(1000000000);
    }
}
