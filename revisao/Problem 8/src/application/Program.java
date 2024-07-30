package application;

import java.util.Random;

public class Program {

    public void run() {
        TestaPilha testaPilha = new TestaPilha();
        try {

            for (int i = 0; i < 1001; i++) {
                int number = drawnNumber();
                if (number < 0) {
                    testaPilha.pushInStackN(number);
                } else if (number > 0) {
                    testaPilha.pushInStackP(number);
                } else if (number == 0) {
                    testaPilha.removeLastInBoth();
                } else throw new RuntimeException();
            }
        } catch(Exception e) {
            System.err.println("Erro! Algo aconteceu! Tente novamente");
        }
    }

    private int drawnNumber() {
        Random rand = new Random();
        return rand.nextInt(201) - 100;
    }

}