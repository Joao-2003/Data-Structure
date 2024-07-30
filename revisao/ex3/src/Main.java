import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlePistaDecolagem controle = new ControlePistaDecolagem();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nControle de Pista de Decolagem");
            System.out.println("1. Listar número de aviões aguardando na fila de decolagem");
            System.out.println("2. Autorizar decolagem do primeiro avião da fila");
            System.out.println("3. Adicionar um avião à fila de espera");
            System.out.println("4. Listar todos os aviões na fila de espera");
            System.out.println("5. Listar as características do primeiro avião da fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    controle.listarNumeroAvioes();
                    break;
                case 2:
                    controle.autorizarDecolagem();
                    break;
                case 3:
                    System.out.print("Digite o nome do avião: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o identificador do avião: ");
                    int identificador = scanner.nextInt();
                    controle.adicionarAviao(nome, identificador);
                    break;
                case 4:
                    controle.listarAvioes();
                    break;
                case 5:
                    controle.listarPrimeiroAviao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
