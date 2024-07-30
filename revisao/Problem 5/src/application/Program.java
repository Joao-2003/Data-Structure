package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Program {
    private Random rand = new Random();

    public void run() {
        try {
            Queue<Integer> queueF = new LinkedList<>();
            Stack<Integer> stackP = new Stack<>();

            queueF.add(drawnNumber());
            for (int i = 0; i < 1001; i++) {
                int num = drawnNumber();
                if(!queueF.contains(num)) {
                    queueF.add(drawnNumber());
                } else {
                    stackP.add(num);
                }
            }

            System.out.print("Queue F = ");
            System.out.println(queueF);
            System.out.print("Stack P = ");
            System.out.println(stackP);

        } catch (Exception e) {
            System.out.println("Error! Something wrong occurred!");
        }
    }

    private int drawnNumber() {
        return rand.nextInt(100000);
    }
}
