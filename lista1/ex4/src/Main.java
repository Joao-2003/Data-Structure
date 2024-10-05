import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] vector1 = new int[100000];

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = ((int) (Math.random() * 10000));
        }
        long start = System.nanoTime();
        int[] vector2 = Arrays.stream(vector1).sorted().toArray();
        long stop = System.nanoTime();
        long sort_time = stop - start;
        Search search = new Search();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número para descobrir quanto tempo demora para encotrar ele: ");
        int k = scanner.nextInt();
        long start1 = System.nanoTime();
        search.BinarySearch(vector2, k);
        long stop1 = System.nanoTime();
        long search_time = stop1 - start1;
        System.out.println("Tempo de execução sem ordenacao: " + (search_time / 1_000_000.0) + " milissegundos");
        System.out.println("Tempo de execução com ordenacao: " + ((sort_time+search_time) / 1_000_000.0) + " milissegundos");
    }
}