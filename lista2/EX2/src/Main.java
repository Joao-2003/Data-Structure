public class Main {
    public static void main(String[] args) {
        int[] vector = new int[100000];
        long[][] results = new long[6][10]; // 6 algoritmos, 10 execuções cada
        String[] names = {"Bubble", "Selection", "Insertion", "Shell", "Merge", "Quick"};
        Sort sort = new Sort();

        @FunctionalInterface
        interface SortAlgorithm {
            void sort(int[] array, int start, int end);
        }

        SortAlgorithm[] algorithms = {
                sort::bubbleSort,
                sort::selectionSort,
                sort::insertionSort,
                sort::shellSort,
                sort::mergeSort,
                sort::quickSort,
        };

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < vector.length; k++) {
                vector[k] = (int) (Math.random() * 100000);
            }
            for (int i = 0; i < algorithms.length; i++) {
                int[] aux = vector.clone(); // Clonar o vetor para cada execução
                long startTime = System.currentTimeMillis();
                algorithms[i].sort(aux, 0, aux.length - 1);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                results[i][j] = elapsedTime;
            }
        }

        System.out.println("Tempos em milisegundos: ");
        for (int i = 0; i < algorithms.length; i++) {
            System.out.print(names[i] + ": ");
            for (int j = 0; j < 10; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
        //Tempos em milisegundos:
        //Bubble: 12890 19823 11793 11773 11768 11806 11728 11735 11754 11867
        //Selection: 3142 2633 1428 1451 1464 1468 1456 1455 1468 1455
        //Insertion: 1671 1436 1361 421 415 421 430 413 409 413
        //Shell: 14 11 10 11 10 10 10 11 11 10
        //Merge: 3692 2650 2595 2581 2593 2589 2590 2593 2609 2606
        //Quick: 12 14 9 7 7 9 8 8 7 8
        //Os resultados foram mais ou menos esperados, mas o Merge sort decepcionou, enquanto o shell sort surpreendeu!
    }
}
