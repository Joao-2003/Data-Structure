public class Main {
    public static void main(String[] args) {
        int[] vector = new int[100000];
        long[][] results = new long[7][10]; // 7 algoritmos, 10 execuções cada
        String[] names = {"Bubble", "Selection", "Insertion", "Shell", "Merge", "Quick", "Dual Pivot Quick"};
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
                sort::dualPivotQuickSort
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
        //Bubble: 11677 11760 10933 12058 11963 11971 12122 12087 11991 12022
        //Selection: 2340 2363 1313 1447 1455 1467 1466 1507 1449 1431
        //Insertion: 1275 1192 1320 415 395 413 424 405 427 427
        //Shell: 10 11 10 10 10 10 10 10 9 10
        //Merge: 2800 2488 2614 2603 2629 2628 2603 2604 2613 2609
        //Quick: 10 10 10 10 4 0 10 11 11 10
        //Dual Pivot Quick: 13 0 0 10 10 10 11 0 10 10
        //Os resultados foram praticamente iguais aos do exercício 2, mas o dualPivotQuickSort conseguiu se sair ainda melhor que o quickSort
    }
}
