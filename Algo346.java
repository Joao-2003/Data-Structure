import java.util.List;
import java.util.Scanner;

public class Algo346 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String frase;

        do {
            System.out.println("Menu\n");
            System.out.println("1 - Imprime o comprimento da frase\n");
            System.out.println("2 - Imprime os dois primeiros e os dois ultimos caracteres da frase\n");
            System.out.println("3 - Imprime a frase espelhada\n");
            System.out.println("4 - Termina o algoritmo");
            input = scanner.nextLine();
            if(input.equals("1")){
                System.out.println("Digite uma frase:\n");
                frase = scanner.nextLine();
                System.out.println("O numero de caracteres da frase eh: " + frase.length());
            }
            else if(input.equals("2")){
                System.out.println("Digite uma frase:\n");
                frase = scanner.nextLine();
                System.out.println("Os 2 primeiros e 2 ultimos caracteres sao, respectivamente: " + frase.charAt(0) + frase.charAt(1) + frase.charAt(frase.length()-2) + frase.charAt(frase.length()-1));
            }
            else if(input.equals("3")){
                System.out.println("Digite uma frase:\n");
                frase = scanner.nextLine();
                String stringEspelhada = new StringBuilder(frase).reverse().toString();
                System.out.println(stringEspelhada);
                System.out.println("A frase invertida eh: " + stringEspelhada);
            }
            else if(input.equals("4")){
                System.out.println("Encerrando o programa...\n");
            }
            else{
                System.out.println("Opcao invalida. Digite valores de 1 a 4\n");
            }
        } while (!input.equals("4"));
    }
}


