import java.util.Arrays;

public class Sort {

    public void bubbleSort(int[] vector, int start, int end){
        for(int i = 0; i < vector.length - 1; i++){
            for(int j = 0; j < vector.length - i - 1; j++){
                if(vector[j] > vector[j+1]){
                    int aux = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = aux;
                }
            }
            //System.out.println(Arrays.toString(vector));
        }
    }

    public void selectionSort(int[] vector, int start, int end){
        for(int i = 0; i < vector.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j< vector.length; j++){
                if(vector[j] < vector[minIndex]){
                    minIndex = j;
                }
            }
            int aux = vector[i];
            vector[i] = vector[minIndex];
            vector[minIndex] = aux;
            //System.out.println(Arrays.toString(vector));
        }
    }

    public void insertionSort(int[] vector, int start, int end){
        for(int i = 1; i < vector.length; i++){
            int value = vector[i];
            int j = i - 1;
            while(j >= 0 && vector[j] > value){
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = value;
            //System.out.println(Arrays.toString(vector));
        }
    }

    public void shellSort(int[] vector, int start, int end){
        int size = vector.length;
        int h = 1;
        while(h < size){
            h = h * 3 + 1;
        }
        while(h > 1){
            h /= 3;
            for(int i = h; i < size; i++){
                int value = vector[i];
                int j = i - h;
                while(j >= 0 && value < vector[j]){
                    vector[j + h] = vector[j];
                    j -= h;
                }
                vector[j + h] = value;
                //System.out.println(Arrays.toString(vector));
            }
        }
    }


    public void mergeSort(int[] vector, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int mid = (left + right) / 2;
            mergeSort(vector, left, mid);
            mergeSort(vector, mid + 1, right);
            merge(vector, left, mid, right);
            //System.out.println(Arrays.toString(vector));
        }
    }

    public void merge(int[] vector, int left, int mid, int right) {
        int[] temp = new int[vector.length];
        for (int i = left; i <= right; i++) {
            temp[i] = vector[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                vector[k] = temp[i];
                i++;
            } else {
                vector[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            vector[k] = temp[i];
            i++;
            k++;
        }
        while (j <= right) {
            vector[k] = temp[j];
            j++;
            k++;
        }
    }



    public void quickSort(int[] vector, int start, int end){
        if(start < end){
            int index_pivot = partitionsHoare(vector, start, end);
            quickSort(vector, start, index_pivot - 1);
            quickSort(vector, index_pivot + 1, end);
        }
    }

    public int partitionsLomuto(int[] vector, int start, int end){
        int pivot = vector[start];
        int i = start;

        for (int j = start + 1; j <= end; j++){
            if(vector[j] <= pivot){
                i += 1;

                int temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
            //System.out.println(Arrays.toString(vector));
        }
        int temp = vector[start];
        vector[start] = vector[i];
        vector[i] = temp;
        return i;
    }

    public int partitionsHoare(int[] vector, int start, int end){
        int i = start + 1;
        int j = end;
        int pivot = vector[start];

        while(i <= j){
            while(i <= j && vector[i] <= pivot){
                i++;
            }
            while(i <= j && vector[j] > pivot){
                j--;
            }
            if(i < j){
                int temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
            //System.out.println(Arrays.toString(vector));
        }
        int temp = vector[start];
        vector[start] = vector[j];
        vector[j] = temp;
        return j;
    }


    public void dualPivotQuickSort(int[] vector, int low, int high) {
        if (low < high) {
            // Particiona o array usando dois pivôs
            int[] pivots = partition(vector, low, high);
            int p1 = pivots[0];
            int p2 = pivots[1];

            // Recursivamente ordena as três partes
            dualPivotQuickSort(vector, low, p1 - 1);
            dualPivotQuickSort(vector, p1 + 1, p2 - 1);
            dualPivotQuickSort(vector, p2 + 1, high);
        }
    }


    private int[] partition(int[] vector, int low, int high) {
        if (vector[low] > vector[high]) {
            swap(vector, low, high);
        }
        int pivot1 = vector[low];
        int pivot2 = vector[high];

        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i <= gt) {
            if (vector[i] < pivot1) {
                swap(vector, i, lt);
                lt++;
            } else if (vector[i] > pivot2) {
                swap(vector, i, gt);
                gt--;
                i--; // Reavaliar o elemento trocado
            }
            i++;
            //System.out.println(Arrays.toString(vector));
        }

        lt--;
        gt++;

        // Coloca os pivôs em suas posições corretas
        swap(vector, low, lt);
        swap(vector, high, gt);

        // Retorna as posições dos pivôs
        return new int[]{lt, gt};
    }

    private void swap(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }
}


