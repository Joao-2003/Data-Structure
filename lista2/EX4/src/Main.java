public class Main {
    public static void main(String[] args) {
        int[] vector = new int[100000];
        long[] results = new long[20];
        Sort sort = new Sort();

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < vector.length; k++) {
                vector[k] = (int) (Math.random() * 100000);
            }
            int[] aux = vector.clone();
            long startTime = System.currentTimeMillis();
            sort.bubbleSort(aux);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            results[j] = elapsedTime;

            aux = vector.clone();
            startTime = System.currentTimeMillis();
            sort.bestBubbleSort(aux);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            results[10 + j] = elapsedTime;
        }

        System.out.println("Tempos em milisegundos: ");
        System.out.print("Bubble: ");
        for (int j = 0; j < 10; j++) {
            System.out.print(results[j] + " ");
        }
        System.out.println();
        System.out.print("Optimized Bubble: ");
        for (int j = 10; j < 20; j++) {
            System.out.print(results[j] + " ");
        }
        System.out.println();
        //Tempos em milisegundos:
        //Bubble: 11600 11554 11728 11696 11946 11728 11653 11740 11690 11770
        //Optimized Bubble: 11575 11798 12100 11988 12059 12014 12115 12058 12071 11993
        //O bubble sort otimizado foi praticamente igual o bubble normal, mas se os vetores fossem parcialmente ordenados,
        //ele se sairia substancialmente melhor.
    }
}
