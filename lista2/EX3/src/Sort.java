import java.util.Arrays;
import java.util.List;

public class Sort {

    public void insertionSort(int[] vector){
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

    public void insertionSort(List<Integer> list, int value){
        int i = list.size() - 1;
        list.add(value); // Adiciona o valor no final da lista para aumentar o tamanho

        while (i >= 0 && list.get(i) > value) {
            list.set(i + 1, list.get(i)); // Move o elemento para a direita
            i--;
        }
        list.set(i + 1, value);
    }

}


