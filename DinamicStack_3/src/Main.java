import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] vector = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            vector[i] = random.nextInt(1, 10);
        }
        DinamicStack stack1 = new DinamicStack();
        DinamicStack stack2 = new DinamicStack();
        DinamicStack stack3 = new DinamicStack();
        for (int i = 0; i < 100; i++) {
            if (vector[i] <= 3) {
                stack1.push(vector[i]);
            } else if (vector[i] <= 6) {
                stack2.push(vector[i]);
            } else {
                stack3.push(vector[i]);
            }
        }
        System.out.println("Pilha 1");
        stack1.print();
        System.out.println("Pilha 2");
        stack2.print();
        System.out.println("Pilha 3");
        stack3.print();
        

        for (int i = 0; i < 100; i++) {
            vector[i] = random.nextInt(1, 4);
            if (vector[i] == 1) {
                if (!stack2.isEmpty()) {
                    int pop2 = stack2.pop();
                    System.out.println("Empilhando o número " + pop2 + " na pilha 1");
                    stack1.push(pop2);
                } else {
                    System.out.println("A pilha 2 está vazia.");
                }
                if (!stack3.isEmpty()) {
                    int pop3 = stack3.pop();
                    System.out.println("Empilhando o número " + pop3 + " na pilha 1");
                    stack1.push(pop3);
                } else {
                    System.out.println("A pilha 3 está vazia.");
                }
            } else if (vector[i] == 2) {
                if (!stack1.isEmpty()) {
                    int pop1 = stack1.pop();
                    System.out.println("Empilhando o número " + pop1 + " na pilha 2");
                    stack2.push(pop1);
                } else {
                    System.out.println("A pilha 1 está vazia.");
                }
                if (!stack3.isEmpty()) {
                    int pop3 = stack3.pop();
                    System.out.println("Empilhando o número " + pop3 + " na pilha 2");
                    stack2.push(pop3);
                } else {
                    System.out.println("A pilha 3 está vazia.");
                }
            } else {
                if (!stack1.isEmpty()) {
                    int pop1 = stack1.pop();
                    System.out.println("Empilhando o número " + pop1 + " na pilha 3");
                    stack3.push(pop1);
                } else {
                    System.out.println("A pilha 1 está vazia.");
                }
                if (!stack2.isEmpty()) {
                    int pop2 = stack2.pop();
                    System.out.println("Empilhando o número " + pop2 + " na pilha 3");
                    stack3.push(pop2);
                } else {
                    System.out.println("A pilha 2 está vazia.");
                }
            }
        }

        System.out.println("Pilha 1");
        stack1.print();
        System.out.println("Pilha 2");
        stack2.print();
        System.out.println("Pilha 3");
        stack3.print();
    }
}
