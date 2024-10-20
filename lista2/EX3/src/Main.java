import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> sortedList = new ArrayList<>();
        Sort sort = new Sort();

        System.out.println("Digite a quantidade de valores que deseja inserir:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o valor " + (i + 1) + ":");
            int value = scanner.nextInt();
            sort.insertionSort(sortedList, value);
            System.out.println("Lista ordenada até agora: " + sortedList);
        }

        scanner.close();
    }
}