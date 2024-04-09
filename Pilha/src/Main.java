import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        String frase = sc.nextLine();
        frase.toUpperCase();
        String[] palavras = frase.split(" ");
        for (int i = 0; i < palavras.length; i++){
            String palavra = palavras[i];
            String[] letras = palavra.split("");
            for (int j = 0; j < letras.length; j++){
                String letra = letras[j];
                stack.push(letra);
            }
            stack.printStack();
            System.out.print(" ");
            stack.destroyStack();
        }
    }
}