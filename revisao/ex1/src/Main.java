import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        String frase = sc.nextLine();
        String upperCase = frase.toUpperCase().replaceAll("[\\s.]", "");
        System.out.println(upperCase);

        for (char c : upperCase.toCharArray()) {
            stack.push(String.valueOf(c));
        }

        StringBuilder inverted = new StringBuilder();

        while (!stack.isEmpty()) {
            inverted.append(stack.peek());
            stack.pop();
        }

        System.out.println(inverted.toString());

        if (upperCase.equals(inverted.toString())) {
            System.out.println("eh um palindromo");
        } else {
            System.out.println("nao eh palindromo");
        }
    }
}