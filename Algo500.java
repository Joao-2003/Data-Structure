import java.util.Scanner;

public class Algo500 {
    static int[] num = new int[5];
    static int[] numl = new int[5];
    static int flag = 0;
    static int flagl = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n\n\n");
            System.out.println("\n VETORES \n");
            System.out.println("\n1 Dados do VETOR A");
            System.out.println("\n2 Dados do VETOR B");
            System.out.println("\n3 Imprime VETORES");
            System.out.println("\n4 Soma VETORES");
            System.out.println("\n5 Subtrai VETORES");
            System.out.println("\n6 Sai do programa");
            System.out.print("\nOPCAO:");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    entrada(num, "A");
                    flag = 1;
                    break;
                case 2:
                    entrada(numl, "B");
                    flagl = 1;
                    break;
                case 3:
                    if (flag != 0 && flagl != 0) {
                        imprime(num, "A");
                        imprime(numl, "B");
                    } else {
                        System.out.println("\nEscolha primeiro opcoes 1 e 2");
                    }
                    break;
                case 4:
                    if (flag != 0 && flagl != 0) {
                        soma();
                    } else {
                        System.out.println("\nEscolha primeiro opcoes 1 e 2");
                    }
                    break;
                case 5:
                    if (flag != 0 && flagl != 0) {
                        subtrai();
                    } else {
                        System.out.println("\nEscolha primeiro opcoes 1 e 2");
                    }
                    break;
                case 6:
                    System.out.println("\nSaindo do Algoritmo");
                    break;
                default:
                    System.out.println("\nopcao invalida");
            }
        } while (op != 6);
        scanner.close();
    }

    public static void entrada(int[] vet, String c) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEntrada do VETOR " + c);
        for (int L = 0; L < vet.length; L++) {
            System.out.print("Digite numero " + (L + 1) + ": ");
            vet[L] = scanner.nextInt();
        }
    }

    public static void imprime(int[] vet, String c) {
        System.out.println("\nVETOR " + c);
        for (int L = 0; L < vet.length; L++) {
            System.out.println((L + 1) + " - " + vet[L]);
        }
    }

    public static void soma() {
        System.out.println("\nSOMA");
        for (int L = 0; L < num.length; L++) {
            int s = num[L] + numl[L];
            System.out.println(s);
        }
    }

    public static void subtrai() {
        System.out.println("\nDIFERENCA");
        for (int L = 0; L < num.length; L++) {
            int d = num[L] - numl[L];
            System.out.println(d);
        }
    }
}
