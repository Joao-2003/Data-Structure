package application;

import java.util.Stack;

public class TestaPilha {

    private final Stack<Integer> stackP = new Stack<>();
    private final Stack<Integer> stackN = new Stack<>();


    public void pushInStackP(int number) {
        stackP.push(number);
    }
    public void pushInStackN(int number) {
        stackN.push(number);
    }

    public void removeLastInBoth() {
        System.out.println("Removing: stackP = " + stackP.getLast() + " | stackN = " + stackN.getLast());
        stackP.pop();
        stackN.pop();
    }
}
