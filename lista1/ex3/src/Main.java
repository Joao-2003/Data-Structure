import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] vector1 = new int[100000];

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = ((int) (Math.random() * 10000));
        }

        Search search = new Search();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número para descobrir quanto tempo demora para encotrar ele: ");
        int k = scanner.nextInt();
        long start = System.nanoTime();
        search.LinearSearch(vector1, k);
        long stop = System.nanoTime();
        long time = stop - start;
        System.out.println("Tempo de execução: " + time + " nanosegundos");
        System.out.println("Tempo de execução: " + (time / 1_000_000.0) + " milissegundos");
    }
}