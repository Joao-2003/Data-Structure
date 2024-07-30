import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        Stack<String> auxStack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        System.out.println("Pilha original: " + stack);
        System.out.print("Digite a chave a ser removida: ");
        String chave = sc.nextLine().toUpperCase();


        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (!top.equals(chave)) {
                auxStack.push(top);
            }
        }


        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }

        System.out.println("Pilha após remoção: " + stack);
    }
}
