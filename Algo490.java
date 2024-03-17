import java.util.Scanner;

public class Algo490 {
    public static void main(String[] args){
        int num;
        String c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o quantidade de palavras: ");
        num = scanner.nextInt();
        // Consumir a quebra de linha restante
        scanner.nextLine();
        System.out.println("Digite o caractere a ser removido: ");
        c = scanner.nextLine().trim();
        String[] nomes = new String[num];
        for (int i = 0; i < num; i++){
            System.out.println("Digite a palavra " + (i+1) + ":");
            nomes[i] = scanner.nextLine();
            nomes[i] = nomes[i].toLowerCase();
            nomes[i] = nomes[i].replace(c, "*");
        }

        for (int i = 0; i < num; i++){
            System.out.println(nomes[i]);
        }
    }
}
