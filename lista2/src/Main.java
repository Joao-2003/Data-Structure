import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] vector =  {3, 4, 9, 2, 5, 8, 1};
        Sort sort = new Sort();
        //sort.bubbleSort(vector);
        //[3, 4, 2, 5, 8, 1, 9]
        //[3, 2, 4, 5, 1, 8, 9]
        //[2, 3, 4, 1, 5, 8, 9]
        //[2, 3, 1, 4, 5, 8, 9]
        //[2, 1, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //sort.selectionSort(vector);
        //[1, 4, 9, 2, 5, 8, 3]
        //[1, 2, 9, 4, 5, 8, 3]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //sort.insertionSort(vector);
        //[3, 4, 9, 2, 5, 8, 1]
        //[3, 4, 9, 2, 5, 8, 1]
        //[2, 3, 4, 9, 5, 8, 1]
        //[2, 3, 4, 5, 9, 8, 1]
        //[2, 3, 4, 5, 8, 9, 1]
        //[1, 2, 3, 4, 5, 8, 9]
        //sort.shellSort(vector);
        //[3, 4, 9, 2, 5, 8, 1]
        //[3, 4, 9, 2, 5, 8, 1]
        //[3, 4, 1, 2, 5, 8, 9]
        //[3, 4, 1, 2, 5, 8, 9]
        //[1, 3, 4, 2, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //sort.mergeSort(vector, 0, vector.length - 1);
        //[3, 4, 9, 2, 5, 8, 1]
        //[3, 4, 2, 9, 5, 8, 1]
        //[2, 3, 4, 9, 5, 8, 1]
        //[2, 3, 4, 9, 5, 8, 1]
        //[2, 3, 4, 9, 1, 5, 8]
        //[1, 2, 3, 4, 5, 8, 9]
        //sort.quickSort(vector, 0, vector.length - 1);
        //[3, 4, 9, 2, 5, 8, 1]
        //[3, 4, 9, 2, 5, 8, 1]
        //[3, 2, 9, 4, 5, 8, 1]
        //[3, 2, 9, 4, 5, 8, 1]
        //[3, 2, 9, 4, 5, 8, 1]
        //[3, 2, 1, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //[1, 2, 3, 4, 5, 8, 9]
        //sort.dualPivotQuickSort(vector, 0, vector.length - 1);
        //[1, 8, 9, 2, 5, 4, 3]
        //[1, 5, 9, 2, 8, 4, 3]
        //[1, 2, 9, 5, 8, 4, 3]
        //[1, 2, 9, 5, 8, 4, 3]
        //[1, 2, 9, 5, 8, 4, 3]
        //[1, 2, 3, 5, 8, 4, 9]
        //[1, 2, 3, 5, 4, 8, 9]
    }
}